package co.com.bodytech.entrenamiento.centroacondicionamiento.events;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.AprendizId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class AprendizCreado extends DomainEvent {

    private final AprendizId aprendizId;
    private final Telefono telefono;
    private final NombreCompleto nombreCompleto;

    public AprendizCreado(AprendizId aprendizId, Telefono telefono, NombreCompleto nombreCompleto) {
        super("co.com.bodytech.entrenamiento.centroacondicionamiento.events.AprendizCreado");
        this.aprendizId = aprendizId;
        this.telefono = telefono;
        this.nombreCompleto = nombreCompleto;
    }

    public AprendizId getAprendizId() {
        return aprendizId;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
