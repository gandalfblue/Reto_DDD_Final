package co.com.bodytech.entrenamiento.centroacondicionamientousecase;

import co.com.bodytech.entrenamiento.centroacondicionamiento.CentroAcondicionamiento;
import co.com.bodytech.entrenamiento.centroacondicionamiento.commands.ActualizarTipoZona;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarTipoZonaUseCase extends UseCase<RequestCommand<ActualizarTipoZona>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ActualizarTipoZona> actualizarTipoZonaRequestCommand) {

        var command = actualizarTipoZonaRequestCommand.getCommand();
        var centroAcondicionamiento = CentroAcondicionamiento.
                from(command.getCentroAcondicionamientoId(),
                        repository().getEventsBy(command.getCentroAcondicionamientoId().value()));

        centroAcondicionamiento.actualizarTipoZonaACardio(command.getZonaId());

        emit().onResponse(new ResponseEvents(centroAcondicionamiento.getUncommittedChanges()));
    }
}
