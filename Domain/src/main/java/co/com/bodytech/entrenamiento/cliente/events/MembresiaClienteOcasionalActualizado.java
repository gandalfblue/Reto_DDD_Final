package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class MembresiaClienteOcasionalActualizado extends DomainEvent {

    private final ClienteId clienteId;

    private final ClienteOcasionalId clienteOcasionalId;
    private final ClienteFrecuenteId clienteFrecuenteId;
    private final Telefono telefono;
    private final Email email;
    private final NombreCompleto nombreCompleto;
    public MembresiaClienteOcasionalActualizado(ClienteId clienteId, ClienteOcasionalId clienteOcasionalId,
                                                ClienteFrecuenteId clienteFrecuenteId, Telefono telefono, Email email, NombreCompleto nombreCompleto) {
        super("co.com.bodytech.entrenamiento.cliente.events.MembresiaClienteOcasionalActualizado");
        this.clienteId = clienteId;

        this.clienteOcasionalId = clienteOcasionalId;
        this.clienteFrecuenteId = clienteFrecuenteId;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
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

    public ClienteFrecuenteId getClienteFrecuenteId() {
        return clienteFrecuenteId;
    }

    public ClienteOcasionalId getClienteOcasionalId() {
        return clienteOcasionalId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
