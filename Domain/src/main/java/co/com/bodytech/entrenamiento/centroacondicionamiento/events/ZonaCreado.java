package co.com.bodytech.entrenamiento.centroacondicionamiento.events;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ZonaCreado extends DomainEvent {

    private final CentroAcondicionamientoId  centroAcondicionamientoId;
    private final ZonaId ZonaId;

    public ZonaCreado(CentroAcondicionamientoId centroAcondicionamientoId, ZonaId zonaId) {
        super("co.com.bodytech.entrenamiento.centroacondicionamiento.events.ZonaCreado");
        this.centroAcondicionamientoId = centroAcondicionamientoId;
        ZonaId = zonaId;
    }


    public CentroAcondicionamientoId getCentroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }

    public ZonaId getZonaId() {
        return ZonaId;
    }
}
