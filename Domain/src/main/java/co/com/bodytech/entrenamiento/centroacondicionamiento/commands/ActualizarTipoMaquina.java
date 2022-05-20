package co.com.bodytech.entrenamiento.centroacondicionamiento.commands;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.MaquinaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarTipoMaquina extends Command {

    private final MaquinaId maquinaId;

    public ActualizarTipoMaquina(MaquinaId maquinaId) {
        this.maquinaId = maquinaId;
    }

    public MaquinaId getMaquinaId() {
        return maquinaId;
    }
}
