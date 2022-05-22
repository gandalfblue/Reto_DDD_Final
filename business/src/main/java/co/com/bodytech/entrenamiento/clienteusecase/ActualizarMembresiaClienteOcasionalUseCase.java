package co.com.bodytech.entrenamiento.clienteusecase;

import co.com.bodytech.entrenamiento.cliente.Cliente;
import co.com.bodytech.entrenamiento.cliente.commands.ActualizarMembresiaClienteOcasional;
import co.com.bodytech.entrenamiento.services.ConsultarClienteOcasional;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarMembresiaClienteOcasionalUseCase extends UseCase<RequestCommand<ActualizarMembresiaClienteOcasional>,
        ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarMembresiaClienteOcasional> actualizarMembresiaClienteOcasionalRequestCommand) {

        var command = actualizarMembresiaClienteOcasionalRequestCommand.getCommand();
        var clienteOcasionalService = getService(ConsultarClienteOcasional.class).orElseThrow();
        var cliente = Cliente.from(command.getClienteId(),
                repository().getEventsBy(command.getClienteId().value()));

        cliente.actualizarMembresiaClienteOcasional(
                clienteOcasionalService.consultarPorClienteOcasionalId(command.getClienteOcasionalId()),
                command.getTelefono(), command.getEmail(),command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
