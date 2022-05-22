package co.com.bodytech.entrenamiento.centroacondicionamiento.commands;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.sofka.domain.generic.Command;

public class CrearZona extends Command {

    private final CentroAcondicionamientoId  centroAcondicionamientoId;
    private final ZonaId ZonaId;

    public CrearZona(CentroAcondicionamientoId centroAcondicionamientoId, ZonaId zonaId) {

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
