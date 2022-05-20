package co.com.bodytech.entrenamiento.centroacondicionamiento.values;

import co.com.sofka.domain.generic.Identity;

public class CentroAcondicionamientoId extends Identity {

    public CentroAcondicionamientoId(String id){
        super(id);
    }
    public static CentroAcondicionamientoId of(String id) {
        return new CentroAcondicionamientoId(id);
    }
}
