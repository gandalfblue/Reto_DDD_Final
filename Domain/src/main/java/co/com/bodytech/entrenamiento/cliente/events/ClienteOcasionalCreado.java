package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteOcasionalCreado extends DomainEvent {

    private final ClienteOcasionalId clienteOcasionalId;
    private final NombreCompleto nombreCompleto;
    private final TipoDeCliente tipoDeCliente;
    public ClienteOcasionalCreado(ClienteOcasionalId clienteOcasionalId, NombreCompleto nombreCompleto,
                                  TipoDeCliente tipoDeCliente) {

        super("co.com.bodytech.entrenamiento.ClienteOcasionalCreado");
        this.clienteOcasionalId = clienteOcasionalId;
        this.nombreCompleto = nombreCompleto;
        this.tipoDeCliente = tipoDeCliente;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public TipoDeCliente getTipoDeCliente() {
        return tipoDeCliente;
    }

    public ClienteOcasionalId getClienteOcasionalId() {
        return clienteOcasionalId;
    }
}
