package co.com.bodytech.entrenamiento.genericos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de Valor [OV] générico que puede ser utilizado por varias entidades, otros objetos de valor y/o
 * agregados para obtener el nombre de su(s) parámetro(s)
 * @return nombreCompleto de tipo String
 * @Autores: Andrés Lozada
 */
public class NombreCompleto implements ValueObject<String> {

    private final String nombreCompleto;

    public NombreCompleto(String nombreCompleto) {
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);

        if (this.nombreCompleto.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar en blanco");
        }

        if (this.nombreCompleto.length() > 100){
            throw new IllegalArgumentException("El nombre no permite mas de 100 caracteres");
        }
    }

    public static NombreCompleto of(String nombreCompleto) {
        return new NombreCompleto(nombreCompleto);
    }

    @Override
    public String value() {
        return nombreCompleto;
    }
}
