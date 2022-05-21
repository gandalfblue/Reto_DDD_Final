package co.com.bodytech.entrenamiento.cliente.commands;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.sofka.domain.generic.Command;

public class EliminarClienteOcasional extends Command {

    private final ClienteId clienteId;
    private final CentroAcondicionamientoId centroAcondicionamientoId;

    public EliminarClienteOcasional(ClienteId clienteId, CentroAcondicionamientoId centroAcondicionamientoId) {
        this.clienteId = clienteId;
        this.centroAcondicionamientoId = centroAcondicionamientoId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public CentroAcondicionamientoId getCentroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }
}
