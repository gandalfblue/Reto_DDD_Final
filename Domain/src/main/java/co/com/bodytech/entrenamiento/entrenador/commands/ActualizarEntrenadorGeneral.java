package co.com.bodytech.entrenamiento.entrenador.commands;

import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorGeneralId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;

public class ActualizarEntrenadorGeneral extends Command {

    private final EntrenadorGeneralId entrenadorGeneralId;
    private final Telefono telefono;
    private final Email email;
    private final NombreCompleto nombreCompleto;
    public ActualizarEntrenadorGeneral(EntrenadorGeneralId entrenadorGeneralId, Telefono telefono,
                                       Email email, NombreCompleto nombreCompleto) {

        this.entrenadorGeneralId = entrenadorGeneralId;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public EntrenadorGeneralId getEntrenadorGeneralId() {
        return entrenadorGeneralId;
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
}