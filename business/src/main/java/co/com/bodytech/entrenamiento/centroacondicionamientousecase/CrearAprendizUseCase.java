package co.com.bodytech.entrenamiento.centroacondicionamientousecase;

import co.com.bodytech.entrenamiento.centroacondicionamiento.CentroAcondicionamiento;
import co.com.bodytech.entrenamiento.centroacondicionamiento.commands.CrearAprendiz;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearAprendizUseCase extends UseCase<RequestCommand<CrearAprendiz>,
        ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearAprendiz> crearAprendizRequestCommand) {

        var command =crearAprendizRequestCommand.getCommand();

        var centroAcondicionamiento = CentroAcondicionamiento.
                from(command.getCentroAcondicionamientoId(),
                repository().getEventsBy(command.getCentroAcondicionamientoId().value()));

        centroAcondicionamiento.crearAprendiz(command.getCentroAcondicionamientoId(),
                command.getTelefono(), command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(centroAcondicionamiento.getUncommittedChanges()));
    }
}
