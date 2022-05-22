package co.com.bodytech.entrenamiento.centroacondicionamiento.commands;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.AprendizId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.Command;

public class CrearAprendiz extends Command {

    private final CentroAcondicionamientoId centroAcondicionamientoId;
    private final AprendizId aprendizId;
    private final Telefono telefono;
    private final NombreCompleto nombreCompleto;

    public CrearAprendiz(CentroAcondicionamientoId centroAcondicionamientoId,
                         AprendizId aprendizId, Telefono telefono, NombreCompleto nombreCompleto) {

        this.centroAcondicionamientoId = centroAcondicionamientoId;
        this.aprendizId = aprendizId;
        this.telefono = telefono;
        this.nombreCompleto = nombreCompleto;
    }

    public AprendizId getAprendizId() {
        return aprendizId;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public CentroAcondicionamientoId getCentroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }
}
