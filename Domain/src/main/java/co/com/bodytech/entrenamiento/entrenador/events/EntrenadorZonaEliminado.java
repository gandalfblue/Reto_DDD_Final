package co.com.bodytech.entrenamiento.entrenador.events;

import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.sofka.domain.generic.DomainEvent;

public class EntrenadorZonaEliminado extends DomainEvent {

    private final EntrenadorZonaId entrenadorZonaId;
    private final EntrenadorId entrenadorId;

    public EntrenadorZonaEliminado(EntrenadorZonaId entrenadorZonaId, EntrenadorId entrenadorId) {
        super("co.com.bodytech.entrenamiento.entrenamiento.EntrenadorZonaEliminado");

        this.entrenadorZonaId = entrenadorZonaId;
        this.entrenadorId = entrenadorId;
    }

    public EntrenadorZonaId getEntrenadorZonaId() {
        return entrenadorZonaId;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
    }
}
