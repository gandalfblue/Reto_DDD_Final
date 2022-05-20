package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteVIPCreado extends DomainEvent {

    private final NombreCompleto nombreCompleto;
    private final ClienteVIPId clienteVIPId;


    public ClienteVIPCreado(NombreCompleto nombreCompleto, ClienteVIPId clienteVIPId) {
        super("co.com.bodytech.entrenamiento.ClienteVIPCreado");
        this.nombreCompleto = nombreCompleto;
        this.clienteVIPId = clienteVIPId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public ClienteVIPId getClienteVIPId() {
        return clienteVIPId;
    }
}
