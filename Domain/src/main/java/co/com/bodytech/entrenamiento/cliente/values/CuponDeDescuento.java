package co.com.bodytech.entrenamiento.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CuponDeDescuento implements ValueObject<Integer> {

    private final Integer cuponDescuento;

    public CuponDeDescuento(Integer cuponDescuento) {
        this.cuponDescuento = Objects.requireNonNull(cuponDescuento);

        if (this.cuponDescuento <= 0){
            throw new IllegalArgumentException("El cupon de descuento no puede ser menor o igual a 0");
        }

        if (String.valueOf(this.cuponDescuento).isBlank()){
            throw new IllegalArgumentException("El cupon de descuento no puede estar vacio");
        }

        if (!this.cuponDescuento.equals(this.cuponDescuento.intValue())){
            throw new IllegalArgumentException("El cupon de descuento no puede tener decimales");
        }
    }

    @Override
    public Integer value() {
        return cuponDescuento;
    }
}
