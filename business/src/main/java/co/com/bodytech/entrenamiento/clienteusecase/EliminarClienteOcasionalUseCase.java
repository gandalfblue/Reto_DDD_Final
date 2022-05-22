package co.com.bodytech.entrenamiento.clienteusecase;

import co.com.bodytech.entrenamiento.cliente.Cliente;
import co.com.bodytech.entrenamiento.cliente.events.MembresiaClienteOcasionalActualizado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class EliminarClienteOcasionalUseCase extends UseCase<TriggeredEvent<MembresiaClienteOcasionalActualizado>,
                                                                                            ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<MembresiaClienteOcasionalActualizado> membresiaClienteOcasionalActualizadoTriggeredEvent) {

        var evento = membresiaClienteOcasionalActualizadoTriggeredEvent.getDomainEvent();

        var cliente = Cliente.from(evento.getClienteId(),
                repository().getEventsBy(evento.getClienteId().value()));

        cliente.eliminarClienteOcasional(evento.getClienteOcasionalId());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
