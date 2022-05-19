package co.com.bodytech.entrenamiento.genericos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 *
 */
public class Telefono implements ValueObject<String> {

    private final String telefono;

    public Telefono(String telefono) {
        this.telefono = Objects.requireNonNull(telefono);

        if (this.telefono.isBlank()){
            throw new IllegalArgumentException("El telefono no puede estar en blanco");
        }

        if (this.telefono.length() > 20){
            throw new IllegalArgumentException("El telefono no permite mas de 20 caracteres");
        }
    }

    @Override
    public Object value() {
        return telefono;
    }
}
