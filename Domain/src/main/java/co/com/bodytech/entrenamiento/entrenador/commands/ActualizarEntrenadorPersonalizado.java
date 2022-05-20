package co.com.bodytech.entrenamiento.entrenador.commands;

import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.entrenador.values.CantidadDeClientes;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorPersonalizadoId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;

public class ActualizarEntrenadorPersonalizado extends Command {

    private final EntrenadorPersonalizadoId entrenadorPersonalizadoId;

    private final CantidadDeClientes cantidadDeClientes;
    private final Telefono telefono;
    private final Email email;
    private final NombreCompleto nombreCompleto;

    public ActualizarEntrenadorPersonalizado(EntrenadorPersonalizadoId entrenadorPersonalizadoId,
                                             CantidadDeClientes cantidadDeClientes, Telefono telefono, Email email, NombreCompleto nombreCompleto) {

        this.entrenadorPersonalizadoId = entrenadorPersonalizadoId;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.cantidadDeClientes = cantidadDeClientes;
    }

    public EntrenadorPersonalizadoId getEntrenadorPersonalizadoId() {
        return entrenadorPersonalizadoId;
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

    public CantidadDeClientes getCantidadDeClientes() {
        return cantidadDeClientes;
    }
}
