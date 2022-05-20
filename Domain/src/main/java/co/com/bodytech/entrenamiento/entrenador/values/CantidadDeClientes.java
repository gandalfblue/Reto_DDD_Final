package co.com.bodytech.entrenamiento.entrenador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CantidadDeClientes implements ValueObject<Integer> {

    private final Integer cantidadClientes;


    public CantidadDeClientes(Integer cantidadClientes) {
        this.cantidadClientes = Objects.requireNonNull(cantidadClientes);

        if (this.cantidadClientes <= 0){
            throw new IllegalArgumentException("La cantidad de clientes no puede ser menor o igual a 0");
        }

        if (String.valueOf(this.cantidadClientes).isBlank()){
            throw new IllegalArgumentException("La cantidad de clientes no puede estar vacio");
        }

        if (!this.cantidadClientes.equals(this.cantidadClientes.intValue())){
            throw new IllegalArgumentException("La cantidad de clientes no puede tener decimales");
        }
    }

    public static CantidadDeClientes of(Integer cantidadClientes) {
        return new CantidadDeClientes(cantidadClientes);
    }

    @Override
    public Integer value() {
        return cantidadClientes;
    }
}
