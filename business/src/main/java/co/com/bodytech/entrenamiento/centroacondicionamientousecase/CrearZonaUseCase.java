package co.com.bodytech.entrenamiento.centroacondicionamientousecase;

import co.com.bodytech.entrenamiento.centroacondicionamiento.CentroAcondicionamiento;
import co.com.bodytech.entrenamiento.centroacondicionamiento.commands.CrearZona;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearZonaUseCase extends UseCase<RequestCommand<CrearZona>,
        ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearZona> crearZonaRequestCommand) {

        var command =crearZonaRequestCommand.getCommand();

        var centroAcondicionamiento = CentroAcondicionamiento.
                from(command.getCentroAcondicionamientoId(),
                        repository().getEventsBy(command.getCentroAcondicionamientoId().value()));

        centroAcondicionamiento.crearZona(command.getCentroAcondicionamientoId());

        emit().onResponse(new ResponseEvents(centroAcondicionamiento.getUncommittedChanges()));
    }
}
