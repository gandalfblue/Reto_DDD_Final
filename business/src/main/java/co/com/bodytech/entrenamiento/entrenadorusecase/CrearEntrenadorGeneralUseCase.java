package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.entrenador.Entrenador;
import co.com.bodytech.entrenamiento.entrenador.commands.CrearEntrenadorGeneral;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearEntrenadorGeneralUseCase extends UseCase<RequestCommand<CrearEntrenadorGeneral>,
        ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearEntrenadorGeneral> crearEntrenadorGeneralRequestCommand) {

        var command =crearEntrenadorGeneralRequestCommand.getCommand();

        var entrenador = new Entrenador(command.getCentroAcondicionamientoId(),
            command.getEntrenadorId(), command.getEntrenadorGeneralId(), command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));
    }
}
