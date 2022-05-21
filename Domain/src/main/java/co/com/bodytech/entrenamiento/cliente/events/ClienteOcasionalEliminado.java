package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteOcasionalEliminado extends DomainEvent {

    private final ClienteId clienteId;

    public ClienteOcasionalEliminado(ClienteId clienteId) {

        super("co.com.bodytech.entrenamiento.cliente.ClienteOcasionalEliminado");
        this.clienteId = clienteId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
