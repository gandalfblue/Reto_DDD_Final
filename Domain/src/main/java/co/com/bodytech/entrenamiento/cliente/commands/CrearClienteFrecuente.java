package co.com.bodytech.entrenamiento.cliente.commands;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.Command;

public class CrearClienteFrecuente extends Command {

    private final ClienteId clienteId;
    private final CentroAcondicionamientoId centroAcondicionamientoId;
    private final ClienteFrecuenteId clienteFrecuenteId;
    private final NombreCompleto nombreCompleto;

    public CrearClienteFrecuente(ClienteId clienteId, CentroAcondicionamientoId centroAcondicionamientoId,
                                    ClienteFrecuenteId clienteFrecuenteId, NombreCompleto nombreCompleto) {

        this.clienteId = clienteId;
        this.centroAcondicionamientoId = centroAcondicionamientoId;
        this.clienteFrecuenteId = clienteFrecuenteId;
        this.nombreCompleto = nombreCompleto;
    }

    public ClienteFrecuenteId getClienteFrecuenteId() {
        return clienteFrecuenteId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public CentroAcondicionamientoId getCentroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }
}
