package co.com.bodytech.entrenamiento.clienteusecase;

import co.com.bodytech.entrenamiento.cliente.Cliente;
import co.com.bodytech.entrenamiento.cliente.commands.EliminarClienteOcasional;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class EliminarClienteOcasionalUseCase extends UseCase<RequestCommand<EliminarClienteOcasional>,
                                                                                            ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EliminarClienteOcasional> eliminarClienteOcasionalRequestCommand) {

        var command = eliminarClienteOcasionalRequestCommand.getCommand();
        var cliente = Cliente.from(command.getClienteId(),
                repository().getEventsBy(command.getClienteId().value()));

        cliente.eliminarClienteOcasional(command.getClienteId());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
