package co.com.bodytech.entrenamiento.centroacondicionamiento.commands;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class CrearCentroAcondicionamiento extends Command {

    private CentroAcondicionamientoId centroAcondicionamientoId;
    private final NombreCompleto nombreCompleto;

    public CrearCentroAcondicionamiento(CentroAcondicionamientoId centroAcondicionamientoId, NombreCompleto nombreCompleto) {

        this.centroAcondicionamientoId = centroAcondicionamientoId;
        this.nombreCompleto = nombreCompleto;
    }

    public CentroAcondicionamientoId getCentroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
