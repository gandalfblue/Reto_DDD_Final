package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.entrenador.Entrenador;
import co.com.bodytech.entrenamiento.entrenador.commands.CrearEntrenadorPersonalizado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearEntrenadorPersonalizadoUseCase extends UseCase<RequestCommand<CrearEntrenadorPersonalizado>,
        ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearEntrenadorPersonalizado> crearEntrenadorPersonalizadoRequestCommand) {

        var command =crearEntrenadorPersonalizadoRequestCommand.getCommand();

        var entrenador = new Entrenador(command.getCentroAcondicionamientoId(),
                command.getEntrenadorId(), command.getEntrenadorPersonalizadolId(), command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));
    }
}
