package co.com.bodytech.entrenamiento.cliente.commands;

import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;

public class CrearClienteFrecuente extends Command {

    private final ClienteFrecuenteId clienteFrecuenteId;
    private final NombreCompleto nombreCompleto;

    public CrearClienteFrecuente(ClienteFrecuenteId clienteFrecuenteId, NombreCompleto nombreCompleto) {

        this.clienteFrecuenteId = clienteFrecuenteId;
        this.nombreCompleto = nombreCompleto;
    }

    public ClienteFrecuenteId getClienteFrecuenteId() {
        return clienteFrecuenteId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
