package co.com.bodytech.entrenamiento.entrenador.events;

import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class EntrenadorZonaActualizado extends DomainEvent {

    private final EntrenadorZonaId entrenadorZonaId;
    private final Telefono telefono;
    private final Email email;
    private final NombreCompleto nombreCompleto;


    public EntrenadorZonaActualizado(EntrenadorZonaId entrenadorZonaId,
                                     Telefono telefono, Email email, NombreCompleto nombreCompleto) {

        super("co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaActualizado");

        this.entrenadorZonaId = entrenadorZonaId;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public EntrenadorZonaId getEntrenadorZonaId() {
        return entrenadorZonaId;
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
