package co.com.bodytech.entrenamiento.entrenador.events;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class EntrenadorZonaCreado extends DomainEvent {

    private final CentroAcondicionamientoId centroAcondicionamientoId;
    private final EntrenadorId EntrenadorId;
    private final EntrenadorZonaId entrenadorZonaId;
    private final NombreCompleto nombreCompleto;


    public EntrenadorZonaCreado(CentroAcondicionamientoId centroAcondicionamientoId, EntrenadorId EntrenadorId,
                                                    EntrenadorZonaId entrenadorZonaId, NombreCompleto nombreCompleto) {

        super("co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaCreado");
        this.centroAcondicionamientoId = centroAcondicionamientoId;
        this.EntrenadorId = EntrenadorId;
        this.entrenadorZonaId = entrenadorZonaId;
        this.nombreCompleto = nombreCompleto;
    }

    public EntrenadorZonaId getEntrenadorZonaId() {
        return entrenadorZonaId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public CentroAcondicionamientoId getCentroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }
}
