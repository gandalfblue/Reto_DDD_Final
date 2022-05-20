package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteOcasionalCreado extends DomainEvent {

    private final ClienteOcasionalId clienteOcasionalId;
    private final NombreCompleto nombreCompleto;

    public ClienteOcasionalCreado(ClienteOcasionalId clienteOcasionalId, NombreCompleto nombreCompleto) {

        super("co.com.bodytech.entrenamiento.ClienteOcasionalCreado");
        this.clienteOcasionalId = clienteOcasionalId;
        this.nombreCompleto = nombreCompleto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public ClienteOcasionalId getClienteOcasionalId() {
        return clienteOcasionalId;
    }
}
