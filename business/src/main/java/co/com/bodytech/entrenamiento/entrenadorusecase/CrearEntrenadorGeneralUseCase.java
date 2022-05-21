package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorGeneralId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class CrearEntrenadorGeneralUseCase extends Command {

    private final EntrenadorId EntrenadorId;
    private final EntrenadorGeneralId entrenadorGeneralId;
    private final NombreCompleto nombreCompleto;


    public CrearEntrenadorGeneralUseCase(EntrenadorId entrenadorId, EntrenadorGeneralId entrenadorGeneralId,
                                         NombreCompleto nombreCompleto) {

        this.EntrenadorId = entrenadorId;
        this.entrenadorGeneralId = entrenadorGeneralId;
        this.nombreCompleto = nombreCompleto;
    }

    public co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId getEntrenadorId() {
        return EntrenadorId;
    }

    public EntrenadorGeneralId getEntrenadorGeneralId() {
        return entrenadorGeneralId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
