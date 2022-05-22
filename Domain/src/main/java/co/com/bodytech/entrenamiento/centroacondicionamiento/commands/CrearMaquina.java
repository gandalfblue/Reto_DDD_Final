package co.com.bodytech.entrenamiento.centroacondicionamiento.commands;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.MaquinaId;
import co.com.sofka.domain.generic.Command;

public class CrearMaquina extends Command {

    private final CentroAcondicionamientoId  centroAcondicionamientoId;
    private final MaquinaId maquinaId;

    public CrearMaquina(CentroAcondicionamientoId centroAcondicionamientoId, MaquinaId maquinaId) {

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
