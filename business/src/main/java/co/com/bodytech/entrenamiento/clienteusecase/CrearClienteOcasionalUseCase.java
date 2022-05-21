package co.com.bodytech.entrenamiento.clienteusecase;

import co.com.bodytech.entrenamiento.cliente.Cliente;
import co.com.bodytech.entrenamiento.cliente.commands.CrearClienteOcasional;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearClienteOcasionalUseCase extends UseCase<RequestCommand<CrearClienteOcasional>,
                                                                         ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearClienteOcasional> crearClienteOcasionalRequestCommand) {

          var command =crearClienteOcasionalRequestCommand.getCommand();

          var cliente = new Cliente(command.getCentroAcondicionamientoId(), command.getClienteId(),
                 command.getClienteOcasionalId(), command.getNombreCompleto());

            emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
