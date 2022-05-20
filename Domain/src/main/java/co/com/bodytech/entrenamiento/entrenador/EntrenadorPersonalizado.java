package co.com.bodytech.entrenamiento.entrenador;

import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.entrenador.values.CantidadDeClientes;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorPersonalizadoId;
import co.com.bodytech.entrenamiento.entrenador.values.TipoDeEntrenador;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;

public class EntrenadorPersonalizado extends AggregateEvent<EntrenadorPersonalizadoId> {

    protected CantidadDeClientes cantidadDeClientes;
    protected Telefono telefono;
    protected Email email;
    protected EntrenadorPersonalizadoId entrenadorPersonalizadoId;
    protected TipoDeEntrenador tipoDeEntrenador;
    protected NombreCompleto nombreCompleto;

    public EntrenadorPersonalizado(EntrenadorPersonalizadoId entrenadorPersonalizadoId) {
        super(entrenadorPersonalizadoId);
    }

    public EntrenadorPersonalizado(EntrenadorPersonalizadoId EntrenadorPersonalizadoId,
       CantidadDeClientes cantidadDeClientes, Telefono telefono, Email email, NombreCompleto nombreCompleto) {

        super(EntrenadorPersonalizadoId);
        this.cantidadDeClientes = cantidadDeClientes;
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public EntrenadorPersonalizado(EntrenadorPersonalizadoId entrenadorPersonalizadoId,
                                   TipoDeEntrenador tipoDeEntrenador, NombreCompleto nombreCompleto) {
        super(entrenadorPersonalizadoId);
        this.tipoDeEntrenador = tipoDeEntrenador;
        this.nombreCompleto = nombreCompleto;
    }

    public void actualizarEntrenadorPersonalizado(EntrenadorPersonalizadoId EntrenadorPersonalizadoId,
                            CantidadDeClientes cantidadDeClientes, Telefono telefono,
                                    Email email, NombreCompleto nombreCompleto){

        this.entrenadorPersonalizadoId = EntrenadorPersonalizadoId.of(EntrenadorPersonalizadoId.value());
        this.cantidadDeClientes = CantidadDeClientes.of(cantidadDeClientes.value());
        this.email = Email.of(email.value());
        this.nombreCompleto = NombreCompleto.of(nombreCompleto.value());
        this.telefono = Telefono.of(telefono.value());
    }
}
