package co.com.bodytech.entrenamiento.cliente;

import co.com.bodytech.entrenamiento.cliente.events.ClienteFrecuenteCreado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalCreado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteVIPCreado;
import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;

/**
 * @
 */
public class Cliente extends AggregateEvent<ClienteId> {

    protected ClienteOcasional clienteOcasional;
    protected ClienteFrecuente clienteFrecuente;
    protected ClienteVIP clienteVIP;
    protected TipoDeCliente tipoDeCliente;
    protected NombreCompleto nombreCompleto;

    public Cliente(ClienteId clienteId) {
        super(clienteId);
        subscribe(new ClienteEventChange(this));
    }

    public Cliente(ClienteId clienteId, ClienteOcasional clienteOcasional, TipoDeCliente tipoDeCliente,
                   NombreCompleto nombreCompleto) {

        super(clienteId);
        appendChange(new ClienteOcasionalCreado(nombreCompleto, tipoDeCliente,
                clienteOcasional.clienteOcasionalId)).apply();
        subscribe(new ClienteEventChange(this));
    }

    public Cliente(ClienteId clienteId, ClienteFrecuente clienteFrecuente, TipoDeCliente tipoDeCliente,
                   NombreCompleto nombreCompleto) {

        super(clienteId);
        appendChange(new ClienteFrecuenteCreado(nombreCompleto, tipoDeCliente,
                clienteFrecuente.clienteFrecuenteId)).apply();
        subscribe(new ClienteEventChange(this));
    }

    public Cliente(ClienteId clienteId, ClienteVIP clienteVIP, TipoDeCliente tipoDeCliente,
                   NombreCompleto nombreCompleto) {

        super(clienteId);
        appendChange(new ClienteVIPCreado(nombreCompleto, tipoDeCliente, clienteVIP.clienteVIPId)).apply();
        subscribe(new ClienteEventChange(this));
    }

    public void actualizarClienteClienteVIP(ClienteVIPId clienteVIPId, Telefono telefono,
                                            Email email, NombreCompleto nombreCompleto){
        appendChange(new ClienteVIPActualizado(clienteVIPId, telefono, email, nombreCompleto)).apply();
    }

    public void eliminarCliente(ClienteId clienteId, TipoDeCliente tipoDeCliente, NombreCompleto nombreCompleto){


    }

    public void actualizarClienteOcasional(ClienteOcasionalId clienteOcasionalId, Telefono telefono,
                                           Email email, NombreCompleto nombreCompleto){

    }

    public void actualizarClienteFrecuente(ClienteFrecuenteId clienteFrecuenteId, Telefono telefono,
                                           Email email, NombreCompleto nombreCompleto){


    }

    public ClienteOcasional clienteOcasional() {
        return clienteOcasional;
    }

    public ClienteFrecuente clienteFrecuente() {
        return clienteFrecuente;
    }

    public ClienteVIP clienteVIP() {
        return clienteVIP;
    }

    public TipoDeCliente tipoDeCliente() {
        return tipoDeCliente;
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }
}
