package co.com.bodytech.entrenamiento.cliente;

import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;

/**
 *
 */
public class ClienteFrecuente extends AggregateEvent<ClienteFrecuenteId> {

    protected ClienteFrecuenteId clienteFrecuenteId;
    protected ClienteOcasionalId clienteOcasionalId;
    protected Telefono telefono;

    protected TipoDeCliente tipoDeCliente;
    protected Email email;
    protected NombreCompleto nombreCompleto;

    public ClienteFrecuente(ClienteFrecuenteId clienteFrecuenteId) {
        super(clienteFrecuenteId);
    }

    public ClienteFrecuente(ClienteFrecuenteId clienteFrecuenteId, Telefono telefono,
                            Email email, NombreCompleto nombreCompleto) {

        super(clienteFrecuenteId);
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public ClienteFrecuente(ClienteFrecuenteId clienteFrecuenteId, TipoDeCliente tipoDeCliente,
                                NombreCompleto nombreCompleto) {

        super(clienteFrecuenteId);
        this.tipoDeCliente = tipoDeCliente;
        this.nombreCompleto = nombreCompleto;

    }

    public void actualizarClienteFrecuente(ClienteFrecuenteId clienteFrecuenteId, Telefono telefono,
                                           Email email, NombreCompleto nombreCompleto){

        this.clienteFrecuenteId = ClienteFrecuenteId.of(clienteFrecuenteId.value());
        this.email = Email.of(email.value());
        this.nombreCompleto = NombreCompleto.of(nombreCompleto.value());
        this.telefono = Telefono.of(telefono.value());
    }
}
