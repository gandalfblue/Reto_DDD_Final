package co.com.bodytech.entrenamiento.entrenador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ZonaDeTrabajo implements ValueObject<ZonaDeTrabajo.Zona> {

    private final Zona zonaTrabajo;

    public ZonaDeTrabajo(Zona zonaTrabajo) {
        this.zonaTrabajo = Objects.requireNonNull(zonaTrabajo);
    }

    public enum Zona {
        Zona_Cardio, Zona_Fuerza, Zona_Trabajo_Grupal
    }

    public static ZonaDeTrabajo of(Zona zonaTrabajo) {
        return new ZonaDeTrabajo(zonaTrabajo);
    }

    @Override
    public ZonaDeTrabajo.Zona value() {
        return zonaTrabajo;
    }
}
