package co.com.bodytech.entrenamiento.cliente;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {

    private final String email;


    public Email(String email) {
        this.email = Objects.requireNonNull(email);

        if (this.email.isBlank()){
            throw new IllegalArgumentException("El email no puede estar en blanco");
        }

        if (this.email.length() > 50){
            throw new IllegalArgumentException("El email no permite mas de 50 caracteres");
        }
    }

    @Override
    public String value() {
        return email;
    }
}
