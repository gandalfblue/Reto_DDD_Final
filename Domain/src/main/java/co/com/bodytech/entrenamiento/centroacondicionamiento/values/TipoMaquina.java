package co.com.bodytech.entrenamiento.centroacondicionamiento.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoMaquina implements ValueObject<TipoMaquina.Tipo> {

    private final Tipo tipoMaquina;

    public TipoMaquina(Tipo tipoMaquina) {
        this.tipoMaquina = Objects.requireNonNull(tipoMaquina);
    }

    public enum Tipo {
        Maquina_Cardio, Maquina_Fuerza, Maquina_Espalda, Maquina_Pierna
    }

    public static TipoMaquina of(Tipo tipoMaquina) {
        return new TipoMaquina(tipoMaquina);
    }

    @Override
    public Tipo value() {
        return tipoMaquina;
    }
}
