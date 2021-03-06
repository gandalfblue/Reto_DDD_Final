package co.com.bodytech.entrenamiento.centroacondicionamientousecase;

import co.com.bodytech.entrenamiento.centroacondicionamiento.CentroAcondicionamiento;
import co.com.bodytech.entrenamiento.centroacondicionamiento.commands.ActualizarAprendiz;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarAprendizUseCase extends UseCase<RequestCommand<ActualizarAprendiz>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarAprendiz> actualizarAprendizRequestCommand) {

        var command = actualizarAprendizRequestCommand.getCommand();
        var centroAcondicionamiento = CentroAcondicionamiento.
                from(command.getCentroAcondicionamientoId(),
                repository().getEventsBy(command.getCentroAcondicionamientoId().value()));

        centroAcondicionamiento.actualizarAprendiz(command.getAprendizId(),command.getTelefono(),
                command.getEmail(),command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(centroAcondicionamiento.getUncommittedChanges()));
    }
}
