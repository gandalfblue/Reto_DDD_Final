package co.com.bodytech.entrenamiento.cliente.values;

import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de Valor [OV], que es utilizado por la entidade Cliente, para obtener el tipo de cliente,
 * por medio de enum.
 * @Autores: Andrés Lozada
 */
public class TipoDeCliente implements ValueObject<TipoDeCliente.Tipo> {

    private final Tipo tipoCliente;

    public TipoDeCliente(Tipo tipoCliente) {
        this.tipoCliente = Objects.requireNonNull(tipoCliente);
    }

    public enum Tipo {
        Cliente_Ocasional, Cliente_Frecuente, ClienteVIP
    }

    public static TipoDeCliente of(Tipo tipoCliente) {
        return new TipoDeCliente(tipoCliente);
    }

    @Override
    public TipoDeCliente.Tipo value() {
        return tipoCliente;
    }
}
