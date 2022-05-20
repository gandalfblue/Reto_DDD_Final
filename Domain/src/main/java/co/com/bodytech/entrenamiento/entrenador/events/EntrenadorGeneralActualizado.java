package co.com.bodytech.entrenamiento.entrenador.events;

import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorGeneralId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class EntrenadorGeneralActualizado extends DomainEvent {

    private final EntrenadorGeneralId entrenadorGeneralId;
    private final Telefono telefono;
    private final Email email;
    private final NombreCompleto nombreCompleto;
    public EntrenadorGeneralActualizado(EntrenadorGeneralId entrenadorGeneralId, Telefono telefono,
                                            Email email, NombreCompleto nombreCompleto) {

        super("co.com.bodytech.entrenamiento.entrenador.events.EntrenadorGeneralActualizado");
        this.entrenadorGeneralId = entrenadorGeneralId;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public EntrenadorGeneralId getEntrenadorGeneralId() {
        return entrenadorGeneralId;
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
