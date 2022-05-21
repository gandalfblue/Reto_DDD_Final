package co.com.bodytech.entrenamiento.cliente.commands;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class CrearClienteVIP extends Command {

    private final CentroAcondicionamientoId centroAcondicionamientoId;
    private final ClienteId clienteId;
    private final NombreCompleto nombreCompleto;
    private final ClienteVIPId clienteVIPId;


    public CrearClienteVIP(CentroAcondicionamientoId centroAcondicionamientoId,
                           ClienteId clienteId, NombreCompleto nombreCompleto, ClienteVIPId clienteVIPId) {

        this.centroAcondicionamientoId = centroAcondicionamientoId;
        this.clienteId = clienteId;
        this.nombreCompleto = nombreCompleto;
        this.clienteVIPId = clienteVIPId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public ClienteVIPId getClienteVIPId() {
        return clienteVIPId;
    }

    public CentroAcondicionamientoId getCentroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
