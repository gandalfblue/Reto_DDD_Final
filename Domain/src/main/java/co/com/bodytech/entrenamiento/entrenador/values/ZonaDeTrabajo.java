package co.com.bodytech.entrenamiento.entrenador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ZonaDeTrabajo implements ValueObject<String> {

    private final String zonaTrabajo;

    public ZonaDeTrabajo(String zonaTrabajo) {
        this.zonaTrabajo = Objects.requireNonNull(zonaTrabajo);

        if (this.zonaTrabajo.isBlank()){
            throw new IllegalArgumentException("La zona de trabajo no puede estar vacia");
        }

        if (this.zonaTrabajo.length() > 50){
            throw new IllegalArgumentException("La zona de trabajo no permite mas de 50 caracteres");
        }
    }

    public static ZonaDeTrabajo of(String zonaTrabajo) {
        return new ZonaDeTrabajo(zonaTrabajo);
    }

    @Override
    public String value() {
        return zonaTrabajo;
    }
}
