package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class CrearEntrenadorZonaUseCase extends Command {

    private final EntrenadorId EntrenadorId;
    private final EntrenadorZonaId entrenadorZonaId;
    private final NombreCompleto nombreCompleto;


    public CrearEntrenadorZonaUseCase(EntrenadorId EntrenadorId, EntrenadorZonaId entrenadorZonaId,
                                      NombreCompleto nombreCompleto) {

        this.EntrenadorId = EntrenadorId;
        this.entrenadorZonaId = entrenadorZonaId;
        this.nombreCompleto = nombreCompleto;
    }

    public EntrenadorZonaId getEntrenadorZonaId() {
        return entrenadorZonaId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
