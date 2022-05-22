package co.com.bodytech.entrenamiento.cliente;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.events.ClienteFrecuenteActualizado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteFrecuenteCreado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalActualizado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalCreado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalEliminado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteVIPActualizado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteVIPCreado;
import co.com.bodytech.entrenamiento.cliente.events.MembresiaClienteOcasionalActualizado;
import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

/**
 *
 */
public class Cliente extends AggregateEvent<ClienteId> {

    protected ClienteId clienteId;
    protected CentroAcondicionamientoId centroAcondicionamientoId;
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

    public Cliente(CentroAcondicionamientoId centroAcondicionamientoId, ClienteId clienteId,
                                        ClienteOcasionalId clienteOcasionalId, NombreCompleto nombreCompleto) {

        super(clienteId);
        appendChange(new ClienteOcasionalCreado(centroAcondicionamientoId, clienteOcasionalId, nombreCompleto)).apply();
        subscribe(new ClienteEventChange(this));
    }

    public Cliente(CentroAcondicionamientoId centroAcondicionamientoId, ClienteId clienteId,
                                    ClienteFrecuenteId clienteFrecuenteId, NombreCompleto nombreCompleto) {

        super(clienteId);
        appendChange(new ClienteFrecuenteCreado(centroAcondicionamientoId, clienteFrecuenteId, nombreCompleto)).apply();
        subscribe(new ClienteEventChange(this));
    }

    public Cliente(CentroAcondicionamientoId centroAcondicionamientoId, ClienteId clienteId,
                                            ClienteVIPId clienteVIPId, NombreCompleto nombreCompleto) {

        super(clienteId);
        appendChange(new ClienteVIPCreado(centroAcondicionamientoId, nombreCompleto, clienteVIPId)).apply();
        subscribe(new ClienteEventChange(this));
    }

    public static Cliente from(ClienteId clienteId, List<DomainEvent> events){
        var cliente = new Cliente(clienteId);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    public void actualizarClienteVIP(ClienteVIPId clienteVIPId, Telefono telefono,
                                     Email email, NombreCompleto nombreCompleto){

        appendChange(new ClienteVIPActualizado(clienteVIPId, telefono, email, nombreCompleto)).apply();
    }

    public void eliminarClienteOcasional(ClienteOcasionalId clienteOcasionalId){
        appendChange(new ClienteOcasionalEliminado(clienteOcasionalId, clienteId)).apply();
    }

    public void actualizarClienteOcasional(ClienteOcasionalId clienteOcasionalId, Telefono telefono,
                                           Email email, NombreCompleto nombreCompleto){

        appendChange(new ClienteOcasionalActualizado(clienteOcasionalId, telefono, email,
                nombreCompleto)).apply();
    }

    public void actualizarMembresiaClienteOcasional(ClienteOcasionalId clienteOcasionalId, Telefono telefono,
                                           Email email, NombreCompleto nombreCompleto){

        var clienteFrecuenteId = new ClienteFrecuenteId();

        appendChange(new MembresiaClienteOcasionalActualizado(clienteId, clienteOcasionalId, clienteFrecuenteId,
                telefono, email, nombreCompleto)).apply();
    }

    public void actualizarClienteFrecuente(ClienteFrecuenteId clienteFrecuenteId, Telefono telefono,
                                           Email email, NombreCompleto nombreCompleto){

        appendChange(new ClienteFrecuenteActualizado(clienteFrecuenteId, clienteOcasionalId, telefono, email,
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
