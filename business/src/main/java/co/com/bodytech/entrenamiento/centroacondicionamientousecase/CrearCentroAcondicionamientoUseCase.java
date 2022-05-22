package co.com.bodytech.entrenamiento.centroacondicionamientousecase;

import co.com.bodytech.entrenamiento.centroacondicionamiento.CentroAcondicionamiento;
import co.com.bodytech.entrenamiento.centroacondicionamiento.commands.CrearCentroAcondicionamiento;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearCentroAcondicionamientoUseCase extends UseCase<RequestCommand<CrearCentroAcondicionamiento>,
        ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCentroAcondicionamiento>
                                           crearCentroAcondicionamientoRequestCommand) {

        var command =crearCentroAcondicionamientoRequestCommand.getCommand();

        var centroAcondicionamiento = new CentroAcondicionamiento(command.getCentroAcondicionamientoId(),
                command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(centroAcondicionamiento.getUncommittedChanges()));
    }
}
