package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorPersonalizadoId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class CrearEntrenadorPersonalizadoUseCase extends Command {

    private final EntrenadorId EntrenadorId;
    private final EntrenadorPersonalizadoId entrenadorPersonalizadolId;
    private final NombreCompleto nombreCompleto;


    public CrearEntrenadorPersonalizadoUseCase(EntrenadorId entrenadorId,
                                               EntrenadorPersonalizadoId entrenadorPersonalizadolId, NombreCompleto nombreCompleto) {

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