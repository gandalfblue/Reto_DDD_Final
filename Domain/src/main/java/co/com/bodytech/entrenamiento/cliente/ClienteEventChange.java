package co.com.bodytech.entrenamiento.cliente;

import co.com.bodytech.entrenamiento.cliente.events.ClienteFrecuenteActualizado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteFrecuenteCreado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalActualizado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalCreado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteVIPActualizado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteVIPCreado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteVIPEliminado;
import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.sofka.domain.generic.EventChange;

public class ClienteEventChange extends EventChange {
    public ClienteEventChange(Cliente cliente) {

        apply((ClienteFrecuenteCreado evento) ->{
            cliente.nombreCompleto = evento.getNombreCompleto();
            cliente.clienteFrecuente = new ClienteFrecuente(evento.getClienteFrecuenteId(),
                    new TipoDeCliente(TipoDeCliente.Tipo.Cliente_Frecuente), evento.getNombreCompleto());
        });

        apply((ClienteOcasionalCreado evento) ->{
            cliente.nombreCompleto = evento.getNombreCompleto();
            cliente.clienteOcasional = new ClienteOcasional(evento.getClienteOcasionalId(),
                    new TipoDeCliente(TipoDeCliente.Tipo.Cliente_Ocasional), evento.getNombreCompleto());
        });

        apply((ClienteVIPCreado evento) ->{
            cliente.nombreCompleto = evento.getNombreCompleto();
            cliente.clienteVIP = new ClienteVIP(evento.getClienteVIPId(),
                    new TipoDeCliente(TipoDeCliente.Tipo.ClienteVIP), evento.getNombreCompleto());
        });


        apply((ClienteOcasionalActualizado evento)->{

            var clienteOcasionalId = evento.getClienteOcasionalId();
            var telefono = evento.getTelefono();
            var nombreCompleto = evento.getNombreCompleto();
            var email = evento.getEmail();

            cliente.clienteOcasional.actualizarClienteOcasional(clienteOcasionalId, telefono,
                    email, nombreCompleto);
        });

        apply((ClienteVIPActualizado evento)->{

            var clienteVIPId = evento.getClienteVIPId();
            var telefono = evento.getTelefono();
            var nombreCompleto = evento.getNombreCompleto();
            var email = evento.getEmail();

            cliente.clienteVIP.actualizarClienteClienteVIP(clienteVIPId, telefono, email, nombreCompleto);
        });

        apply((ClienteVIPEliminado evento) ->{

            cliente.clienteVIP = null;

        });

        apply((ClienteFrecuenteActualizado evento)->{

            var clienteFrecuenteId = evento.getClienteFrecuenteId();
            var telefono = evento.getTelefono();
            var nombreCompleto = evento.getNombreCompleto();
            var email = evento.getEmail();

            cliente.clienteFrecuente.actualizarClienteFrecuente(clienteFrecuenteId, telefono,
                                    email, nombreCompleto);
        });
    }
}
