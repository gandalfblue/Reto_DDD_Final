package co.com.bodytech.entrenamiento.cliente;

import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.EventChange;

public class ClienteEventChange extends EventChange {
    public ClienteEventChange(Cliente cliente) {



        apply((ClienteVIPActualizado events)->{

            var clienteVIPId = events.getClienteVIPId();
            var telefono = events.getTelefono();
            var nombreCompleto = events.getNombreCompleto();

            cliente.clienteVIP.


        });
    }
}
