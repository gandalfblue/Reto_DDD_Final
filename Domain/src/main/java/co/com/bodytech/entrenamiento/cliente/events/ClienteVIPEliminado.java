package co.com.bodytech.entrenamiento.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ClienteVIPEliminado extends DomainEvent {

    public ClienteVIPEliminado() {
        super("co.com.bodytech.entrenamiento.cliente.ClienteVIPEliminado");
    }
}
