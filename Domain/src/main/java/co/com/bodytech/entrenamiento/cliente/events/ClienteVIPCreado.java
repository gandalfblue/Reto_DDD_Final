package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteVIPCreado extends DomainEvent {

    private final CentroAcondicionamientoId centroAcondicionamientoId;
    private final NombreCompleto nombreCompleto;
    private final ClienteVIPId clienteVIPId;


    public ClienteVIPCreado(CentroAcondicionamientoId centroAcondicionamientoId,
                                    NombreCompleto nombreCompleto, ClienteVIPId clienteVIPId) {

        super("co.com.bodytech.entrenamiento.cliente.ClienteVIPCreado");
        this.centroAcondicionamientoId = centroAcondicionamientoId;
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
}
