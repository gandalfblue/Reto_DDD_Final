package co.com.bodytech.entrenamiento.cliente;

import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;

/**
 *
 */
public class ClienteOcasional extends AggregateEvent<ClienteOcasionalId> {

   protected TipoDeCliente tipoDeCliente;
    protected ClienteOcasionalId clienteOcasionalId;
    protected Telefono telefono;
    protected Email email;
    protected NombreCompleto nombreCompleto;

    public ClienteOcasional(ClienteOcasionalId clienteOcasionalId) {
        super(clienteOcasionalId);
    }

    public ClienteOcasional(ClienteOcasionalId clienteOcasionalId, Telefono telefono,
                            Email email, NombreCompleto nombreCompleto) {

        super(clienteOcasionalId);
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public ClienteOcasional(ClienteOcasionalId clienteOcasionalId, TipoDeCliente tipoDeCliente,
                            NombreCompleto nombreCompleto) {
        super(clienteOcasionalId);
        this.tipoDeCliente = tipoDeCliente;
        this.nombreCompleto = nombreCompleto;
    }

    public void actualizarClienteOcasional(ClienteOcasionalId clienteOcasionalId, Telefono telefono,
                                           Email email, NombreCompleto nombreCompleto){

        if (nombreCompleto.value().isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar en blanco");
        }

        if (String.valueOf(telefono.value()).isBlank()){
            throw new IllegalArgumentException("El telefono no puede estar vacio");
        }

        if (email.value().isBlank()){
            throw new IllegalArgumentException("El email no puede estar vacio");
        }

        if (clienteOcasionalId.value().isBlank()){
            throw new IllegalArgumentException("El id del cliente ocasional no puede estar vacio");
        }

        this.clienteOcasionalId = ClienteOcasionalId.of(clienteOcasionalId.value());
        this.email = Email.of(email.value());
        this.nombreCompleto = NombreCompleto.of(nombreCompleto.value());
        this.telefono = Telefono.of(telefono.value());
    }
}
