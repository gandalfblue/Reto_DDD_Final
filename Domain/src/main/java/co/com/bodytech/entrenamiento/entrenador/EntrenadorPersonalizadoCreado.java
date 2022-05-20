package co.com.bodytech.entrenamiento.entrenador;

import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorPersonalizadoId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class EntrenadorPersonalizadoCreado extends DomainEvent {

    private final EntrenadorId EntrenadorId;
    private final EntrenadorPersonalizadoId entrenadorPersonalizadolId;
    private final NombreCompleto nombreCompleto;


    public EntrenadorPersonalizadoCreado(EntrenadorId entrenadorId,
             EntrenadorPersonalizadoId entrenadorPersonalizadolId, NombreCompleto nombreCompleto) {

        super("co.com.bodytech.entrenamiento.entrenador.EntrenadorPersonalizadoCreado");

        this.EntrenadorId = entrenadorId;
        this.entrenadorPersonalizadolId = entrenadorPersonalizadolId;
        this.nombreCompleto = nombreCompleto;
    }

    public co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId getEntrenadorId() {
        return EntrenadorId;
    }

    public EntrenadorPersonalizadoId getEntrenadorPersonalizadolId() {
        return entrenadorPersonalizadolId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
