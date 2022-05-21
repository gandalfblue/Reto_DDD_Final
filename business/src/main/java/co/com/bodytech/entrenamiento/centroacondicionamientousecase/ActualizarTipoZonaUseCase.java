package co.com.bodytech.entrenamiento.centroacondicionamientousecase;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarTipoZonaUseCase extends Command {

    private final ZonaId zonaId;
    public ActualizarTipoZonaUseCase(ZonaId zonaId) {
        this.zonaId = zonaId;
    }

    public ZonaId getZonaId() {
        return zonaId;
    }
}
