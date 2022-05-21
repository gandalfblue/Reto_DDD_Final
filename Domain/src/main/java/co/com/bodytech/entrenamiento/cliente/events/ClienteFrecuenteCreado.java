package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteFrecuenteCreado extends DomainEvent {

    private final CentroAcondicionamientoId centroAcondicionamientoId;
    private final ClienteFrecuenteId clienteFrecuenteId;
    private final NombreCompleto nombreCompleto;

    public ClienteFrecuenteCreado(CentroAcondicionamientoId centroAcondicionamientoId,
                                  ClienteFrecuenteId clienteFrecuenteId, NombreCompleto nombreCompleto) {

        super("co.com.bodytech.entrenamiento.cliente.ClienteFrecuenteCreado");
        this.centroAcondicionamientoId = centroAcondicionamientoId;
        this.clienteFrecuenteId = clienteFrecuenteId;
        this.nombreCompleto = nombreCompleto;
    }

    public ClienteFrecuenteId getClienteFrecuenteId() {
        return clienteFrecuenteId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public CentroAcondicionamientoId getCentroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }
}
