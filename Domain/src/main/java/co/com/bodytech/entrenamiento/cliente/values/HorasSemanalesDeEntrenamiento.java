package co.com.bodytech.entrenamiento.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class HorasSemanalesDeEntrenamiento implements ValueObject<Integer> {

    private final Integer horasSemanales;

    public HorasSemanalesDeEntrenamiento(Integer horasSemanales) {
        this.horasSemanales = Objects.requireNonNull(horasSemanales);

        if (this.horasSemanales <= 0){
            throw new IllegalArgumentException("La cantidad de horas semanales no puede ser menor o igual a 0");
        }

        if (String.valueOf(this.horasSemanales).isBlank()){
            throw new IllegalArgumentException("La cantidad de horas semanales no puede estar vacio");
        }

        if (!this.horasSemanales.equals(this.horasSemanales.intValue())){
            throw new IllegalArgumentException("La cantidad de horas semanales no puede tener decimales");
        }
    }

    public static HorasSemanalesDeEntrenamiento of(Integer horasSemanales) {
        return new HorasSemanalesDeEntrenamiento(horasSemanales);
    }

    @Override
    public Integer value() {
        return horasSemanales;
    }
}
