package co.com.bodytech.entrenamiento.centroacondicionamiento.events;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.AprendizId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.MaquinaId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class CentroAcondicionamientoCreado extends DomainEvent {

    private final ZonaId zonaId;
    private final MaquinaId maquinaId;
    private final AprendizId aprendizId;
    private final NombreCompleto nombreCompleto;


    public CentroAcondicionamientoCreado(ZonaId zonaId, MaquinaId maquinaId,
                                            AprendizId aprendizId, NombreCompleto nombreCompleto) {

        super("co.com.bodytech.entrenamiento.CentroAcondicionamiento.CentroAcondicionamientoCreado");
        this.zonaId = zonaId;
        this.maquinaId = maquinaId;
        this.aprendizId = aprendizId;
        this.nombreCompleto = nombreCompleto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public ZonaId getZonaId() {
        return zonaId;
    }

    public MaquinaId getMaquinaId() {
        return maquinaId;
    }

    public AprendizId getAprendizId() {
        return aprendizId;
    }
}
