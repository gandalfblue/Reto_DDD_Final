package co.com.bodytech.entrenamiento.cliente;

import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.cliente.values.CuponDeDescuento;
import co.com.bodytech.entrenamiento.cliente.values.HorasSemanalesDeEntrenamiento;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;

/**
 *
 */
public class ClienteVIP extends AggregateEvent<ClienteVIPId> {

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

    public void actualizarClienteClienteVIPId(ClienteVIPId clienteVIPId, Telefono telefono,
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

        if (clienteVIPId.value().isBlank()){
            throw new IllegalArgumentException("El id del cliente VIP no puede estar vacio");
        }

        this.clienteVIPId = clienteVIPId;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }
}
