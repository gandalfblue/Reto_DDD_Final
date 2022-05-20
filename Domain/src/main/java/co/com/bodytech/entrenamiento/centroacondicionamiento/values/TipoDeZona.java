package co.com.bodytech.entrenamiento.centroacondicionamiento.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeZona implements ValueObject<TipoDeZona.Tipo> {

    private final Tipo tipoZona;

    public TipoDeZona(Tipo tipoZona) {
        this.tipoZona = Objects.requireNonNull(tipoZona);
    }

    public enum Tipo {
        Zona_Cardio, Zona_Pesas, Zona_Vestier, Zona_Duchas
    }

    public static TipoDeZona of(Tipo tipoZona) {
        return new TipoDeZona(tipoZona);
    }

    @Override
    public Tipo value() {
        return tipoZona;
    }
}
