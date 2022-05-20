package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteVIPCreado extends DomainEvent {

    private final NombreCompleto nombreCompleto;
    private final TipoDeCliente tipoDeCliente;
    private final ClienteVIPId clienteVIPId;
    public ClienteVIPCreado(NombreCompleto nombreCompleto, TipoDeCliente tipoDeCliente, ClienteVIPId clienteVIPId) {
        super("co.com.bodytech.entrenamiento.ClienteVIPCreado");
        this.nombreCompleto = nombreCompleto;
        this.tipoDeCliente = tipoDeCliente;
        this.clienteVIPId = clienteVIPId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public TipoDeCliente getTipoDeCliente() {
        return tipoDeCliente;
    }

    public ClienteVIPId getClienteVIPId() {
        return clienteVIPId;
    }
}
