package co.com.bodytech.entrenamiento.centroacondicionamiento.values;

import co.com.sofka.domain.generic.Identity;

public class AprendizId extends Identity {

    public AprendizId(String id){
        super(id);
    }

    public AprendizId() {
    }

    public static AprendizId of(String id) {
        return new AprendizId(id);
    }
}
