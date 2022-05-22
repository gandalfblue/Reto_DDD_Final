package co.com.bodytech.entrenamiento.cliente.commands;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.genericos.Email;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.Command;

public class ActualizarMembresiaClienteOcasional extends Command {

    private final ClienteOcasionalId clienteOcasionalId;
    private  final CentroAcondicionamientoId centroAcondicionamientoId;
    private final ClienteId clienteId;
    private final ClienteFrecuenteId clienteFrecuenteId;
    private final Telefono telefono;
    private final Email email;
    private final NombreCompleto nombreCompleto;
    public ActualizarMembresiaClienteOcasional(ClienteOcasionalId clienteOcasionalId, CentroAcondicionamientoId centroAcondicionamientoId,
                                               ClienteId clienteId, ClienteFrecuenteId clienteFrecuenteId,
                                               Telefono telefono, Email email, NombreCompleto nombreCompleto) {
        this.clienteOcasionalId = clienteOcasionalId;

        this.centroAcondicionamientoId = centroAcondicionamientoId;
        this.clienteId = clienteId;
        this.clienteFrecuenteId = clienteFrecuenteId;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Email getEmail() {
        return email;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public ClienteFrecuenteId getClienteFrecuenteId() {
        return clienteFrecuenteId;
    }

    public CentroAcondicionamientoId getCentroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }

    public ClienteOcasionalId getClienteOcasionalId() {
        return clienteOcasionalId;
    }
}
