package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteFrecuenteCreado extends DomainEvent {

    private final ClienteFrecuenteId clienteFrecuenteId;
    private final NombreCompleto nombreCompleto;
    private final TipoDeCliente tipoDeCliente;

    public ClienteFrecuenteCreado(ClienteFrecuenteId clienteFrecuenteId, NombreCompleto nombreCompleto, TipoDeCliente tipoDeCliente) {
        super("co.com.bodytech.entrenamiento.ClienteFrecuenteCreado");
        this.clienteFrecuenteId = clienteFrecuenteId;
        this.nombreCompleto = nombreCompleto;
        this.tipoDeCliente = tipoDeCliente;
    }

    public ClienteFrecuenteId getClienteFrecuenteId() {
        return clienteFrecuenteId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public TipoDeCliente getTipoDeCliente() {
        return tipoDeCliente;
    }
}
