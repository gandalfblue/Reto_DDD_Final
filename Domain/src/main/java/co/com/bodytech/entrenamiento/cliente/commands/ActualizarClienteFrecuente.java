package co.com.bodytech.entrenamiento.cliente.commands;

import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;

public class ActualizarClienteFrecuente extends Command {

    private final ClienteFrecuenteId clienteFrecuenteId;
    private final Telefono telefono;
    private final Email email;
    private NombreCompleto nombreCompleto;

    public ActualizarClienteFrecuente(ClienteFrecuenteId clienteFrecuenteId, Telefono telefono,
                                      Email email, NombreCompleto nombreCompleto) {

        this.clienteFrecuenteId = clienteFrecuenteId;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public ClienteFrecuenteId getClienteFrecuenteId() {
        return clienteFrecuenteId;
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
