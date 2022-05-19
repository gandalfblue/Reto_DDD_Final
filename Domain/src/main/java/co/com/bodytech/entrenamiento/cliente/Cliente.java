package co.com.bodytech.entrenamiento.cliente;

import co.com.sofka.domain.generic.AggregateEvent;

public class Cliente extends AggregateEvent<ClienteId> {

    protected ClienteOcasionalId clienteOcasionalId;
    protected ClienteFrecuenteId clienteFrecuenteId;
    protected ClienteVIPId clienteVIPId;
    protected TipoDeCliente tipoDeCliente;


}
