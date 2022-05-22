package co.com.bodytech.entrenamiento.cliente;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.genericos.Email;
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
    protected CentroAcondicionamientoId centroAcondicionamientoId;
    protected Telefono telefono;
    protected Email email;
    protected NombreCompleto nombreCompleto;

    public ClienteOcasional(ClienteOcasionalId clienteOcasionalId) {
        super(clienteOcasionalId);
    }

    public ClienteOcasional(CentroAcondicionamientoId centroAcondicionamientoId,
            ClienteOcasionalId clienteOcasionalId, TipoDeCliente tipoDeCliente, NombreCompleto nombreCompleto) {
        super(clienteOcasionalId);
        this.tipoDeCliente = tipoDeCliente;
        this.nombreCompleto = nombreCompleto;
        this.centroAcondicionamientoId = centroAcondicionamientoId;
        this.telefono = new Telefono("123456");
        this.email = new Email("afl@sena.edu.co");
    }

    public void actualizarClienteOcasional(ClienteOcasionalId clienteOcasionalId, Telefono telefono,
                                           Email email, NombreCompleto nombreCompleto){

        this.clienteOcasionalId = ClienteOcasionalId.of(clienteOcasionalId.value());
        this.email = Email.of(email.value());
        this.nombreCompleto = NombreCompleto.of(nombreCompleto.value());
        this.telefono = Telefono.of(telefono.value());
    }
}
