package co.com.bodytech.entrenamiento.entrenador.commands;

import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;

public class CrearEntrenadorZona extends Command {

    private final EntrenadorId EntrenadorId;
    private final EntrenadorZonaId entrenadorZonaId;
    private final NombreCompleto nombreCompleto;


    public CrearEntrenadorZona(EntrenadorId EntrenadorId, EntrenadorZonaId entrenadorZonaId,
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
