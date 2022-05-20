package co.com.bodytech.entrenamiento.centroacondicionamiento.events;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoZonaActualizado extends DomainEvent {

    private final ZonaId zonaId;
    public TipoZonaActualizado(ZonaId zonaId) {
        super("co.com.bodytech.entrenamiento.centroacondicionamiento.events.TipoZonaActualizado");
        this.zonaId = zonaId;
    }

    public ZonaId getZonaId() {
        return zonaId;
    }
}
