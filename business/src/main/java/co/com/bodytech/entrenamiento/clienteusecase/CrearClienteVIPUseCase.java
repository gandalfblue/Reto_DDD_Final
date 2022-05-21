package co.com.bodytech.entrenamiento.clienteusecase;

import co.com.bodytech.entrenamiento.cliente.Cliente;
import co.com.bodytech.entrenamiento.cliente.commands.CrearClienteVIP;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearClienteVIPUseCase extends UseCase<RequestCommand<CrearClienteVIP>,
                                                                    ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearClienteVIP> crearClienteVIPRequestCommand) {

        var command =crearClienteVIPRequestCommand.getCommand();

        var cliente = new Cliente(command.getCentroAcondicionamientoId(), command.getClienteId(),
                command.getClienteVIPId(), command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
