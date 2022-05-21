package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteOcasionalCreado extends DomainEvent {

    private final CentroAcondicionamientoId centroAcondicionamientoId;
    private final ClienteOcasionalId clienteOcasionalId;
    private final NombreCompleto nombreCompleto;

    public ClienteOcasionalCreado(CentroAcondicionamientoId centroAcondicionamientoId,
                                  ClienteOcasionalId clienteOcasionalId, NombreCompleto nombreCompleto) {

        super("co.com.bodytech.entrenamiento.cliente.ClienteOcasionalCreado");
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
}
