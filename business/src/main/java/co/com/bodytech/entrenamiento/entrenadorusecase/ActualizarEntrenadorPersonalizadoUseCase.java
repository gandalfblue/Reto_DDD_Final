package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.entrenador.Entrenador;
import co.com.bodytech.entrenamiento.entrenador.commands.ActualizarEntrenadorPersonalizado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarEntrenadorPersonalizadoUseCase extends UseCase<RequestCommand<ActualizarEntrenadorPersonalizado>,
                                                                                    ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarEntrenadorPersonalizado> actualizarEntrenadorPersonalizadoRequestCommand) {

        var command = actualizarEntrenadorPersonalizadoRequestCommand.getCommand();
        var entrenador = Entrenador.from(command.getEntrenadorId(),
                repository().getEventsBy(command.getEntrenadorId().value()));

        entrenador.actualizarEntrenadorPersonalizado(command.getEntrenadorPersonalizadoId(),
                                            command.getCantidadDeClientes(), command.getTelefono(),
                                            command.getEmail(), command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));
    }
}
