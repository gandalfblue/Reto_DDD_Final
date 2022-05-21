package co.com.bodytech.entrenamiento.clienteusecase;

import co.com.bodytech.entrenamiento.cliente.Cliente;
import co.com.bodytech.entrenamiento.cliente.commands.ActualizarClienteVIP;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarClienteVIPUseCase extends UseCase<RequestCommand<ActualizarClienteVIP>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ActualizarClienteVIP> actualizarClienteVIPRequestCommand) {

        var command = actualizarClienteVIPRequestCommand.getCommand();
        var cliente = Cliente.from(command.getClienteId(),
                repository().getEventsBy(command.getClienteId().value()));

        cliente.actualizarClienteVIP(command.getClienteVIPId(),command.getTelefono(),
                command.getEmail(),command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
