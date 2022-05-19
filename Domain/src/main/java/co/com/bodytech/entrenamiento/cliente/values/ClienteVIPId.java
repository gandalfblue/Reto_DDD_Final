package co.com.bodytech.entrenamiento.cliente.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de Valor [OV], que es utilizado por la entidade Cliente, para obtener el id del cliente VIP.
 * @return nombre de tipo String
 * @Autores: Andrés Lozada
 */
public class ClienteVIPId extends Identity {

    public ClienteVIPId(String id) {
        super(id);
    }

    public static ClienteVIPId of(String id) {
        return new ClienteVIPId(id);
    }
}
