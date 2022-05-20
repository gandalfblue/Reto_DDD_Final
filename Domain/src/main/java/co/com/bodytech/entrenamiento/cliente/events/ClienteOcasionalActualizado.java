package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteOcasionalActualizado extends DomainEvent {
    private final ClienteOcasionalId clienteOcasionalId;
    private final Telefono telefono;
    private final Email email;
    private final NombreCompleto nombreCompleto;
    public ClienteOcasionalActualizado(ClienteOcasionalId clienteOcasionalId, Telefono telefono, Email email, NombreCompleto nombreCompleto) {
        super("co.com.bodytech.entrenamiento.ClienteOcasionalActualizado");
        this.clienteOcasionalId = clienteOcasionalId;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public ClienteOcasionalId getClienteOcasionalId() {
        return clienteOcasionalId;
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
