package co.com.bodytech.entrenamiento.entrenador;

import co.com.sofka.domain.generic.Identity;

public class EntrenadorGeneralId extends Identity {

    public EntrenadorGeneralId(String id) {
        super(id);
    }

    public static EntrenadorGeneralId of(String id) {
        return new EntrenadorGeneralId(id);
    }
}
