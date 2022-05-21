package co.com.bodytech.entrenamiento.centroacondicionamiento.commands;

import co.com.bodytech.entrenamiento.centroacondicionamiento.Aprendiz;
import co.com.bodytech.entrenamiento.centroacondicionamiento.Maquina;
import co.com.bodytech.entrenamiento.centroacondicionamiento.Zona;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.AprendizId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.MaquinaId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.sofka.domain.generic.Command;

public class CrearCentroAcondicionamiento extends Command {

    private final Zona zona;
    private final ZonaId zonaId;
    private final Maquina maquina;
    private final MaquinaId maquinaId;
    private final Aprendiz aprendiz;
    private final AprendizId aprendizId;

    public CrearCentroAcondicionamiento(Zona zona, ZonaId zonaId, Maquina maquina,
                                MaquinaId maquinaId, Aprendiz aprendiz, AprendizId aprendizId) {

        this.zona = zona;
        this.zonaId = zonaId;
        this.maquina = maquina;
        this.maquinaId = maquinaId;
        this.aprendiz = aprendiz;
        this.aprendizId = aprendizId;
    }

    public Zona getZona() {
        return zona;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
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
