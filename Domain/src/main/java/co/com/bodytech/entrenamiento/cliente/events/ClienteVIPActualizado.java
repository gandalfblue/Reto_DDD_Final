package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.genericos.Email;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteVIPActualizado extends DomainEvent {

    private final ClienteVIPId clienteVIPId;
    private final Telefono telefono;
    private final Email email;
    private final NombreCompleto nombreCompleto;
    public ClienteVIPActualizado(ClienteVIPId clienteVIPId, Telefono telefono, Email email, NombreCompleto nombreCompleto) {
        super("co.com.bodytech.entrenamiento.cliente.ClienteVIPCreado");
        this.clienteVIPId = clienteVIPId;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public ClienteVIPId getClienteVIPId() {
        return clienteVIPId;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Email getEmail() {
        return email;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
