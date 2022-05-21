package co.com.bodytech.entrenamiento.clienteusecase;

import co.com.bodytech.entrenamiento.cliente.Cliente;
import co.com.bodytech.entrenamiento.cliente.commands.ActualizarClienteFrecuente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarClienteFrecuenteUseCase extends UseCase<RequestCommand<ActualizarClienteFrecuente>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ActualizarClienteFrecuente> actualizarClienteFrecuenteRequestCommand) {

        var command = actualizarClienteFrecuenteRequestCommand.getCommand();
        var cliente = Cliente.from(command.getClienteId(),
                            repository().getEventsBy(command.getClienteId().value()));

        cliente.actualizarClienteFrecuente(command.getClienteFrecuenteId(),command.getTelefono(),
                command.getEmail(),command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
