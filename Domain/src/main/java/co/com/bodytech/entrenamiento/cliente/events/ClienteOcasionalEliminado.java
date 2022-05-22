package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteOcasionalEliminado extends DomainEvent {

    private final ClienteOcasionalId clienteOcasionalId;
    private final ClienteId clienteId;

    public ClienteOcasionalEliminado(ClienteOcasionalId clienteOcasionalId, ClienteId clienteId) {

        super("co.com.bodytech.entrenamiento.cliente.ClienteOcasionalEliminado");
        this.clienteOcasionalId = clienteOcasionalId;
        this.clienteId = clienteId;
    }

    public ClienteOcasionalId getClienteOcasionalId() {
        return clienteOcasionalId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
