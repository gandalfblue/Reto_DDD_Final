package co.com.bodytech.entrenamiento.entrenador.commands;

import co.com.bodytech.entrenamiento.genericos.Email;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.Command;

public class ActualizarEntrenadorZona extends Command {

    private final EntrenadorId entrenadorId;
    private final EntrenadorZonaId entrenadorZonaId;
    private final Telefono telefono;
    private final Email email;
    private final NombreCompleto nombreCompleto;


    public ActualizarEntrenadorZona(EntrenadorId entrenadorId, EntrenadorZonaId entrenadorZonaId,
                                     Telefono telefono, Email email, NombreCompleto nombreCompleto) {

        this.entrenadorId = entrenadorId;
        this.entrenadorZonaId = entrenadorZonaId;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public EntrenadorZonaId getEntrenadorZonaId() {
        return entrenadorZonaId;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Email getEmail() {
        return email;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
    }
}
