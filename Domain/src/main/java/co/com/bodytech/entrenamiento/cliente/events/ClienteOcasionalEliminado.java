package co.com.bodytech.entrenamiento.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ClienteOcasionalEliminado extends DomainEvent {

    public ClienteOcasionalEliminado() {

        super("co.com.bodytech.entrenamiento.cliente.ClienteOcasionalEliminado");
    }
}
