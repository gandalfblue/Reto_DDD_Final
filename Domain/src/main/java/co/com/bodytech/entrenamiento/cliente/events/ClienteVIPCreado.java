package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteVIPCreado extends DomainEvent {
    public ClienteVIPCreado(NombreCompleto nombreCompleto, TipoDeCliente tipoDeCliente, ClienteVIPId clienteVIPId) {
        super("co.com.bodytech.entrenamiento.ClienteVIPCreado");
    }
}
