package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.entrenador.Entrenador;
import co.com.bodytech.entrenamiento.entrenador.commands.ActualizarEntrenadorZona;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarEntrenadorZonaUseCase extends UseCase<RequestCommand<ActualizarEntrenadorZona>,
                                                                                        ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarEntrenadorZona> actualizarEntrenadorZonaRequestCommand) {

        var command = actualizarEntrenadorZonaRequestCommand.getCommand();
        var entrenador = Entrenador.from(command.getEntrenadorId(),
                repository().getEventsBy(command.getEntrenadorId().value()));

        entrenador.actualizarEntrenadorZona(command.getEntrenadorZonaId(),
                command.getTelefono(), command.getEmail(), command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));
    }
}
