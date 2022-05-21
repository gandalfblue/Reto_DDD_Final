package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.entrenador.Entrenador;
import co.com.bodytech.entrenamiento.entrenador.commands.ActualizarEntrenadorGeneral;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarEntrenadorGeneralUseCase extends UseCase<RequestCommand<ActualizarEntrenadorGeneral>,
                                                                                    ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarEntrenadorGeneral> actualizarEntrenadorGeneralRequestCommand) {

        var command = actualizarEntrenadorGeneralRequestCommand.getCommand();
        var entrenador = Entrenador.from(command.getEntrenadorId(),
                repository().getEventsBy(command.getEntrenadorId().value()));

        entrenador.actualizarEntrenadorGeneral(command.getEntrenadorGeneralId(),command.getTelefono(),
                command.getEmail(),command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));
    }
}
