package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.entrenador.Entrenador;
import co.com.bodytech.entrenamiento.entrenador.commands.CrearEntrenadorZona;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearEntrenadorZonaUseCase extends UseCase<RequestCommand<CrearEntrenadorZona>,
        ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearEntrenadorZona> crearEntrenadorZonaRequestCommand) {

        var command =crearEntrenadorZonaRequestCommand.getCommand();

        var entrenador = new Entrenador(command.getCentroAcondicionamientoId(),
                command.getEntrenadorId(), command.getEntrenadorZonaId(), command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));
    }
}
