package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.cliente.ClienteOcasional;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteOcasionalCreado extends DomainEvent {

    private final NombreCompleto nombreCompleto;
    private final TipoDeCliente tipoDeCliente;
    private final ClienteOcasionalId clienteOcasionalId;
    public ClienteOcasionalCreado(NombreCompleto nombreCompleto, TipoDeCliente tipoDeCliente,
                                  ClienteOcasionalId clienteOcasionalId) {

        super("co.com.bodytech.entrenamiento.ClienteOcasionalCreado");
        this.nombreCompleto = nombreCompleto;
        this.tipoDeCliente = tipoDeCliente;
        this.clienteOcasionalId = clienteOcasionalId;
    }
}
