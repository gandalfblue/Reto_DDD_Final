package co.com.bodytech.entrenamiento.cliente;

import co.com.bodytech.entrenamiento.cliente.events.ClienteFrecuenteCreado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalActualizado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalCreado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteVIPActualizado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteVIPCreado;
import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;

/**
 *
 */
public class Cliente extends AggregateEvent<ClienteId> {

    protected ClienteOcasional clienteOcasional;
    protected ClienteOcasionalId clienteOcasionalId;
    protected ClienteFrecuente clienteFrecuente;
    protected ClienteFrecuenteId clienteFrecuenteId;
    protected ClienteVIP clienteVIP;
    protected ClienteVIPId clienteVIPId;
    protected TipoDeCliente tipoDeCliente;
    protected NombreCompleto nombreCompleto;

    public Cliente(ClienteId clienteId) {
        super(clienteId);
        subscribe(new ClienteEventChange(this));
    }

    public Cliente(ClienteId clienteId, ClienteOcasionalId clienteOcasionalId, TipoDeCliente tipoDeCliente,
                    NombreCompleto nombreCompleto) {

        super(clienteId);
        appendChange(new ClienteOcasionalCreado(clienteOcasionalId, nombreCompleto, tipoDeCliente)).apply();
        subscribe(new ClienteEventChange(this));
    }

    public Cliente(ClienteId clienteId, ClienteFrecuenteId clienteFrecuenteId, TipoDeCliente tipoDeCliente,
                   NombreCompleto nombreCompleto) {

        super(clienteId);
        appendChange(new ClienteFrecuenteCreado(clienteFrecuenteId, nombreCompleto, tipoDeCliente)).apply();
        subscribe(new ClienteEventChange(this));
    }

    public Cliente(ClienteId clienteId, ClienteVIPId clienteVIPId, TipoDeCliente tipoDeCliente,
                   NombreCompleto nombreCompleto) {

        super(clienteId);
        appendChange(new ClienteVIPCreado(nombreCompleto, tipoDeCliente, clienteVIPId)).apply();
        subscribe(new ClienteEventChange(this));
    }

    public void actualizarClienteVIP(ClienteVIPId clienteVIPId, Telefono telefono,
                                     Email email, NombreCompleto nombreCompleto){

        appendChange(new ClienteVIPActualizado(clienteVIPId, telefono, email, nombreCompleto)).apply();
    }

    public void eliminarCliente(){
        appendChange(new ClienteVIPEliminado()).apply();
    }

    public void actualizarClienteOcasional(ClienteOcasionalId clienteOcasionalId, Telefono telefono,
                                           Email email, NombreCompleto nombreCompleto){

        appendChange(new ClienteOcasionalActualizado(clienteOcasionalId, telefono, email,
                nombreCompleto)).apply();
    }

    public void actualizarClienteFrecuente(ClienteFrecuenteId clienteFrecuenteId, Telefono telefono,
                                           Email email, NombreCompleto nombreCompleto){

        appendChange(new ClienteFrecuenteActualizado(clienteFrecuenteId, telefono, email,
                nombreCompleto)).apply();
    }

    public ClienteOcasional clienteOcasional() {
        return clienteOcasional;
    }

    public ClienteOcasionalId clienteOcasionalId() {
        return clienteOcasionalId;
    }

    public ClienteFrecuente clienteFrecuente() {
        return clienteFrecuente;
    }

    public ClienteFrecuenteId clienteFrecuenteId() {
        return clienteFrecuenteId;
    }

    public ClienteVIP clienteVIP() {
        return clienteVIP;
    }

    public ClienteVIPId clienteVIPId() {
        return clienteVIPId;
    }

    public TipoDeCliente tipoDeCliente() {
        return tipoDeCliente;
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }
}
