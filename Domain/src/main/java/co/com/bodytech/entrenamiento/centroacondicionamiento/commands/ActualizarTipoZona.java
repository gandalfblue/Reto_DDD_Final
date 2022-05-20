package co.com.bodytech.entrenamiento.centroacondicionamiento.commands;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarTipoZona extends Command {

    private final ZonaId zonaId;
    public ActualizarTipoZona(ZonaId zonaId) {
        this.zonaId = zonaId;
    }

    public ZonaId getZonaId() {
        return zonaId;
    }
}
