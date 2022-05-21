package co.com.bodytech.entrenamiento.cliente.commands;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class CrearClienteOcasional extends Command {

    private final ClienteId clienteId;
    private final CentroAcondicionamientoId centroAcondicionamientoId;
    private final ClienteOcasionalId clienteOcasionalId;
    private final NombreCompleto nombreCompleto;

    public CrearClienteOcasional(ClienteId clienteId, CentroAcondicionamientoId centroAcondicionamientoId,
                                 ClienteOcasionalId clienteOcasionalId, NombreCompleto nombreCompleto) {
        this.clienteId = clienteId;

        this.centroAcondicionamientoId = centroAcondicionamientoId;
        this.clienteOcasionalId = clienteOcasionalId;
        this.nombreCompleto = nombreCompleto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public ClienteOcasionalId getClienteOcasionalId() {
        return clienteOcasionalId;
    }

    public CentroAcondicionamientoId getCentroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
