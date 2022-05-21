package co.com.bodytech.entrenamiento.centroacondicionamientousecase;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.MaquinaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarTipoMaquinaUseCase extends Command {

    private final MaquinaId maquinaId;

    public ActualizarTipoMaquinaUseCase(MaquinaId maquinaId) {
        this.maquinaId = maquinaId;
    }

    public MaquinaId getMaquinaId() {
        return maquinaId;
    }
}
