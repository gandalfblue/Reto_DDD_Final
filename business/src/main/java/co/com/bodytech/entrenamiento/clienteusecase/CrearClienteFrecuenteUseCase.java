package co.com.bodytech.entrenamiento.clienteusecase;

import co.com.bodytech.entrenamiento.cliente.Cliente;
import co.com.bodytech.entrenamiento.cliente.commands.CrearClienteFrecuente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearClienteFrecuenteUseCase extends UseCase<RequestCommand<CrearClienteFrecuente>,
                                                                    ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearClienteFrecuente> crearClienteFrecuenteRequestCommand) {
        var command =crearClienteFrecuenteRequestCommand.getCommand();

        var cliente = new Cliente(command.getCentroAcondicionamientoId(), command.getClienteId(),
                                        command.getClienteFrecuenteId(), command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
