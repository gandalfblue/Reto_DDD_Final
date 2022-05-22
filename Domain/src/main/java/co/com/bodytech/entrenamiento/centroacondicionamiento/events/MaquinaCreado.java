package co.com.bodytech.entrenamiento.centroacondicionamiento.events;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.MaquinaId;
import co.com.sofka.domain.generic.DomainEvent;

public class MaquinaCreado extends DomainEvent {

    private final CentroAcondicionamientoId  centroAcondicionamientoId;
    private final MaquinaId maquinaId;

    public MaquinaCreado(CentroAcondicionamientoId centroAcondicionamientoId, MaquinaId maquinaId) {
        super("co.com.bodytech.entrenamiento.centroacondicionamiento.events.MaquinaCreado");
        this.centroAcondicionamientoId = centroAcondicionamientoId;
        this.maquinaId = maquinaId;
    }

    public CentroAcondicionamientoId getCentroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }

    public MaquinaId getMaquinaId() {
        return maquinaId;
    }
}
