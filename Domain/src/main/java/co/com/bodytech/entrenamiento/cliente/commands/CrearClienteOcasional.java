package co.com.bodytech.entrenamiento.cliente.commands;

import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;

public class CrearClienteOcasional extends Command {

    private final ClienteOcasionalId clienteOcasionalId;
    private final NombreCompleto nombreCompleto;

    public CrearClienteOcasional(ClienteOcasionalId clienteOcasionalId, NombreCompleto nombreCompleto) {

        this.clienteOcasionalId = clienteOcasionalId;
        this.nombreCompleto = nombreCompleto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public ClienteOcasionalId getClienteOcasionalId() {
        return clienteOcasionalId;
    }
}
