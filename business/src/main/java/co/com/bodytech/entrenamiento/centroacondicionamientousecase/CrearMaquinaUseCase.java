package co.com.bodytech.entrenamiento.centroacondicionamientousecase;

import co.com.bodytech.entrenamiento.centroacondicionamiento.CentroAcondicionamiento;
import co.com.bodytech.entrenamiento.centroacondicionamiento.commands.CrearMaquina;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearMaquinaUseCase extends UseCase<RequestCommand<CrearMaquina>,
        ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearMaquina> crearMaquinaRequestCommand) {

        var command =crearMaquinaRequestCommand.getCommand();

        var centroAcondicionamiento = CentroAcondicionamiento.
                from(command.getCentroAcondicionamientoId(),
                        repository().getEventsBy(command.getCentroAcondicionamientoId().value()));

        centroAcondicionamiento.crearMaquina(command.getCentroAcondicionamientoId());

        emit().onResponse(new ResponseEvents(centroAcondicionamiento.getUncommittedChanges()));
    }
}
