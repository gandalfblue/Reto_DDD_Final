package co.com.bodytech.entrenamiento.entrenador;

import co.com.sofka.domain.generic.Identity;

public class EntrenadorZonaId extends Identity{

    public EntrenadorZonaId(String id) {
        super(id);
    }

    public static EntrenadorZonaId of(String id) {
        return new EntrenadorZonaId(id);
    }
}
