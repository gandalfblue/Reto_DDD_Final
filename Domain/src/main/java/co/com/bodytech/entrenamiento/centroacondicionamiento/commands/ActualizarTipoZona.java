package co.com.bodytech.entrenamiento.centroacondicionamiento.commands;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarTipoZona extends Command {

    private final CentroAcondicionamientoId centroAcondicionamientoId;
    private final ZonaId zonaId;
    public ActualizarTipoZona(CentroAcondicionamientoId centroAcondicionamientoId, ZonaId zonaId) {
        this.centroAcondicionamientoId = centroAcondicionamientoId;
        this.zonaId = zonaId;
    }

    public ZonaId getZonaId() {
        return zonaId;
    }

    public CentroAcondicionamientoId getCentroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }
}
