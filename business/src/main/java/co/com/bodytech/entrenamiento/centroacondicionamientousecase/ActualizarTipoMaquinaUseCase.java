package co.com.bodytech.entrenamiento.centroacondicionamientousecase;

import co.com.bodytech.entrenamiento.centroacondicionamiento.CentroAcondicionamiento;
import co.com.bodytech.entrenamiento.centroacondicionamiento.commands.ActualizarTipoMaquina;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarTipoMaquinaUseCase extends UseCase<RequestCommand<ActualizarTipoMaquina>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarTipoMaquina> actualizarTipoMaquinaRequestCommand) {

        var command = actualizarTipoMaquinaRequestCommand.getCommand();
        var centroAcondicionamiento = CentroAcondicionamiento.
                from(command.getCentroAcondicionamientoId(),
                        repository().getEventsBy(command.getCentroAcondicionamientoId().value()));

        centroAcondicionamiento.actualizarTipoMaquinaAFuerza(command.getMaquinaId());

        emit().onResponse(new ResponseEvents(centroAcondicionamiento.getUncommittedChanges()));
    }
}
