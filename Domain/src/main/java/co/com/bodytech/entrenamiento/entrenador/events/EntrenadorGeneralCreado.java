package co.com.bodytech.entrenamiento.entrenador.events;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorGeneralId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class EntrenadorGeneralCreado extends DomainEvent {

    private final CentroAcondicionamientoId centroAcondicionamientoId;
    private final EntrenadorId EntrenadorId;
    private final EntrenadorGeneralId entrenadorGeneralId;
    private final NombreCompleto nombreCompleto;


    public EntrenadorGeneralCreado(CentroAcondicionamientoId centroAcondicionamientoId,
                                   EntrenadorId entrenadorId, EntrenadorGeneralId entrenadorGeneralId,
                                                                    NombreCompleto nombreCompleto) {

        super("co.com.bodytech.entrenamiento.entrenador.events.EntrenadorGeneralCreado");
        this.centroAcondicionamientoId = centroAcondicionamientoId;
        this.EntrenadorId = entrenadorId;
        this.entrenadorGeneralId = entrenadorGeneralId;
        this.nombreCompleto = nombreCompleto;
    }

    public co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId getEntrenadorId() {
        return EntrenadorId;
    }

    public EntrenadorGeneralId getEntrenadorGeneralId() {
        return entrenadorGeneralId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public CentroAcondicionamientoId getCentroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }
}
