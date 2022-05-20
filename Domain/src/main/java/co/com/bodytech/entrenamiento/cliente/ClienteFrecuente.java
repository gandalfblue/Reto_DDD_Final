package co.com.bodytech.entrenamiento.cliente;

import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.cliente.values.HorasSemanalesDeEntrenamiento;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;

/**
 *
 */
public class ClienteFrecuente extends AggregateEvent<ClienteFrecuenteId> {

    protected ClienteFrecuenteId clienteFrecuenteId;
    protected Telefono telefono;
    protected TipoDeCliente tipoDeCliente;
    protected Email email;
    protected NombreCompleto nombreCompleto;

    protected HorasSemanalesDeEntrenamiento horasSemanalesDeEntrenamiento;

    public ClienteFrecuente(ClienteFrecuenteId clienteOcasionalId) {
        super(clienteOcasionalId);
    }

    public ClienteFrecuente(ClienteFrecuenteId clienteOcasionalId, Telefono telefono,
                            Email email, NombreCompleto nombreCompleto,
                            HorasSemanalesDeEntrenamiento horasSemanalesDeEntrenamiento) {

        super(clienteOcasionalId);
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.horasSemanalesDeEntrenamiento = horasSemanalesDeEntrenamiento;
    }

    public ClienteFrecuente(ClienteFrecuenteId clienteFrecuenteId, TipoDeCliente tipoDeCliente,
                                NombreCompleto nombreCompleto) {

        super(clienteFrecuenteId);
        this.tipoDeCliente = tipoDeCliente;
        this.nombreCompleto = nombreCompleto;

    }

    public void actualizarClienteFrecuente(ClienteFrecuenteId clienteFrecuenteId, Telefono telefono,
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

        if (clienteFrecuenteId.value().isBlank()){
            throw new IllegalArgumentException("El id del cliente frecuente no puede estar vacio");
        }

        this.clienteFrecuenteId = ClienteFrecuenteId.of(clienteFrecuenteId.value());
        this.email = Email.of(email.value());
        this.nombreCompleto = NombreCompleto.of(nombreCompleto.value());
        this.telefono = Telefono.of(telefono.value());
    }
}
