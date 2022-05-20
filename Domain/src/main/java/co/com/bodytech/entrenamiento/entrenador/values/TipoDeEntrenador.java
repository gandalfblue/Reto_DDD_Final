package co.com.bodytech.entrenamiento.entrenador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeEntrenador implements ValueObject<TipoDeEntrenador.Tipo> {

    private final Tipo tipoEntrenador;

    public TipoDeEntrenador(Tipo tipoEntrenador) {
        this.tipoEntrenador = Objects.requireNonNull(tipoEntrenador);
    }

    public enum Tipo {
        Entrenador_Personalizado, Entrenador_Zona, Entrenador_General
    }

    public static TipoDeEntrenador of(Tipo tipoEntrenador) {
        return new TipoDeEntrenador(tipoEntrenador);
    }

    @Override
    public Tipo value() {
        return tipoEntrenador;
    }
}
