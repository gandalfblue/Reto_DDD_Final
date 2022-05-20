package co.com.bodytech.entrenamiento.entrenador.values;

import co.com.sofka.domain.generic.Identity;

public class EntrenadorPersonalizadoId extends Identity {

    public EntrenadorPersonalizadoId(String id) {
        super(id);
    }

    public static EntrenadorPersonalizadoId of(String id) {
        return new EntrenadorPersonalizadoId(id);
    }
}
