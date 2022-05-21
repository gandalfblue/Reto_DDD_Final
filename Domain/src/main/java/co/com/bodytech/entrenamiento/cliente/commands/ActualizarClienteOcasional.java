package co.com.bodytech.entrenamiento.cliente.commands;

import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.Command;

public class ActualizarClienteOcasional extends Command {

    private final ClienteId clienteId;
    private final ClienteOcasionalId clienteOcasionalId;
    private final Telefono telefono;
    private final Email email;
    private final NombreCompleto nombreCompleto;

    public ActualizarClienteOcasional(ClienteId clienteId, ClienteOcasionalId clienteOcasionalId,
                                        Telefono telefono, Email email, NombreCompleto nombreCompleto) {

        this.clienteId = clienteId;
        this.clienteOcasionalId = clienteOcasionalId;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public ClienteOcasionalId getClienteOcasionalId() {
        return clienteOcasionalId;
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

    public ClienteId getClienteId() {
        return clienteId;
    }
}
