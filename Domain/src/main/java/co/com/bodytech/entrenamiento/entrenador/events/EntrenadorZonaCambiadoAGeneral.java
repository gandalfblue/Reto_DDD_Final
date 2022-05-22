package co.com.bodytech.entrenamiento.entrenador.events;

import co.com.bodytech.entrenamiento.genericos.Email;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorGeneralId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class EntrenadorZonaCambiadoAGeneral extends DomainEvent {

    private final EntrenadorId entrenadorId;
    private final EntrenadorZonaId entrenadorZonaId;
    private final EntrenadorGeneralId entrenadorGeneralId;
    private final Telefono telefono;
    private final Email email;
    private final NombreCompleto nombreCompleto;
    public EntrenadorZonaCambiadoAGeneral(EntrenadorId entrenadorId, EntrenadorZonaId entrenadorZonaId,
          EntrenadorGeneralId entrenadorGeneralId, Telefono telefono, Email email, NombreCompleto nombreCompleto) {
        super("co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaCambiadoAGeneral");
        this.entrenadorId = entrenadorId;
        this.entrenadorZonaId = entrenadorZonaId;
        this.entrenadorGeneralId = entrenadorGeneralId;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
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

    public EntrenadorGeneralId getEntrenadorGeneralId() {
        return entrenadorGeneralId;
    }
}
