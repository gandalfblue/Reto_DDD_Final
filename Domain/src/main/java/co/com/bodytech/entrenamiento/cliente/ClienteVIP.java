package co.com.bodytech.entrenamiento.cliente;

import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.cliente.values.CuponDeDescuento;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.cliente.values.HorasSemanalesDeEntrenamiento;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;

/**
 *
 */
public class ClienteVIP extends AggregateEvent<ClienteVIPId> {

    protected TipoDeCliente tipoDeCliente;
    protected ClienteVIPId clienteVIPId;
    protected Telefono telefono;
    protected Email email;
    protected NombreCompleto nombreCompleto;
    protected HorasSemanalesDeEntrenamiento horasSemanalesDeEntrenamiento;
    protected CuponDeDescuento cuponDeDescuento;

    public ClienteVIP(ClienteVIPId entityId) {
        super(entityId);
    }

    public ClienteVIP(ClienteVIPId clienteVIPId, Telefono telefono, Email email, NombreCompleto nombreCompleto,
                      HorasSemanalesDeEntrenamiento horasSemanalesDeEntrenamiento) {

        super(clienteVIPId);
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.horasSemanalesDeEntrenamiento = horasSemanalesDeEntrenamiento;
    }

    public ClienteVIP(ClienteVIPId clienteVIPId, TipoDeCliente tipoDeCliente, NombreCompleto nombreCompleto) {
        super(clienteVIPId);
        this.tipoDeCliente = tipoDeCliente;
        this.nombreCompleto = nombreCompleto;
    }

    public void actualizarClienteClienteVIP(ClienteVIPId clienteVIPId, Telefono telefono,
                                           Email email, NombreCompleto nombreCompleto){

        this.clienteVIPId = ClienteVIPId.of(clienteVIPId.value());
        this.email = Email.of(email.value());
        this.nombreCompleto = NombreCompleto.of(nombreCompleto.value());
        this.telefono = Telefono.of(telefono.value());
    }
}
