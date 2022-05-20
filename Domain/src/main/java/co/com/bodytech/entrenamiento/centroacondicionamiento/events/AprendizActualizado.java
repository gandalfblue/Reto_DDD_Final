package co.com.bodytech.entrenamiento.centroacondicionamiento.events;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.AprendizId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class AprendizActualizado extends DomainEvent {

    private final AprendizId aprendizId;
    private final Telefono telefono;
    private final Email email;
    private final NombreCompleto nombreCompleto;
    public AprendizActualizado(AprendizId aprendizId, Telefono telefono,
                               Email email, NombreCompleto nombreCompleto) {

        super("co.com.bodytech.entrenamiento.centroacondicionamiento.events.AprendizActualizado");

        this.aprendizId = aprendizId;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public AprendizId getAprendizId() {
        return aprendizId;
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
