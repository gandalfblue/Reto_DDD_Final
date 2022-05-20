package co.com.bodytech.entrenamiento.centroacondicionamiento.values;

import co.com.sofka.domain.generic.Identity;

public class ZonaId extends Identity {

    public ZonaId(String id) {
        super(id);
    }

    public static ZonaId of(String id) {
        return new ZonaId(id);
    }
}
