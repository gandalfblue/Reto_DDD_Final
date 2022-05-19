package co.com.bodytech.entrenamiento.cliente.events;

import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteFrecuenteCreado extends DomainEvent {
    public ClienteFrecuenteCreado(NombreCompleto nombreCompleto, TipoDeCliente tipoDeCliente, ClienteFrecuenteId clienteFrecuenteId) {
        super();
    }
}
