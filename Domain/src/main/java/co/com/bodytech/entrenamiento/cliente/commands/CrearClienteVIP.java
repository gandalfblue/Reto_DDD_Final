package co.com.bodytech.entrenamiento.cliente.commands;

import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;

public class CrearClienteVIP extends Command {

    private final NombreCompleto nombreCompleto;
    private final ClienteVIPId clienteVIPId;


    public CrearClienteVIP(NombreCompleto nombreCompleto, ClienteVIPId clienteVIPId) {

        this.nombreCompleto = nombreCompleto;
        this.clienteVIPId = clienteVIPId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public ClienteVIPId getClienteVIPId() {
        return clienteVIPId;
    }
}
