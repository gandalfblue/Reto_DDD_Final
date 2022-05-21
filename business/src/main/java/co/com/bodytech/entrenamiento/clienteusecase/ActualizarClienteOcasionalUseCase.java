package co.com.bodytech.entrenamiento.clienteusecase;

import co.com.bodytech.entrenamiento.cliente.Cliente;
import co.com.bodytech.entrenamiento.cliente.commands.ActualizarClienteOcasional;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarClienteOcasionalUseCase extends UseCase<RequestCommand<ActualizarClienteOcasional>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarClienteOcasional> actualizarClienteOcasionalRequestCommand) {

        var command = actualizarClienteOcasionalRequestCommand.getCommand();
        var cliente = Cliente.from(command.getClienteId(),
                repository().getEventsBy(command.getClienteId().value()));

        cliente.actualizarClienteOcasional(command.getClienteOcasionalId(),command.getTelefono(),
                command.getEmail(),command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
