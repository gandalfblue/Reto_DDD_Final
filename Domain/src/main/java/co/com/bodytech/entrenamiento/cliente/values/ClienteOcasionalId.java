package co.com.bodytech.entrenamiento.cliente.values;

import co.com.sofka.domain.generic.Identity;

/**
 *
 */
public class ClienteOcasionalId extends Identity {

    public ClienteOcasionalId(String id) {
        super(id);
    }

    public static ClienteOcasionalId of(String id) {
        return new ClienteOcasionalId(id);
    }
}
