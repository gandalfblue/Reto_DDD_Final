package co.com.bodytech.entrenamiento.entrenador;

import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.bodytech.entrenamiento.entrenador.values.TipoDeEntrenador;
import co.com.bodytech.entrenamiento.entrenador.values.ZonaDeTrabajo;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;

public class EntrenadorZona extends AggregateEvent<EntrenadorZonaId> {

    protected ZonaDeTrabajo zonaDeTrabajo;
    protected Telefono telefono;
    protected Email email;
    protected EntrenadorZonaId entrenadorZonaId;
    protected TipoDeEntrenador tipoDeEntrenador;
    protected NombreCompleto nombreCompleto;

    public EntrenadorZona(EntrenadorZonaId entrenadorZonaId) {
        super(entrenadorZonaId);
    }

    public EntrenadorZona(EntrenadorZonaId entrenadorZonaId, ZonaDeTrabajo zonaDeTrabajo,
                          Telefono telefono, Email email, NombreCompleto nombreCompleto) {

        super(entrenadorZonaId);
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.zonaDeTrabajo = zonaDeTrabajo;
    }

    public EntrenadorZona(EntrenadorZonaId entrenadorZonaId,
                          TipoDeEntrenador tipoDeEntrenador, NombreCompleto nombreCompleto) {
        super(entrenadorZonaId);
        this.tipoDeEntrenador = tipoDeEntrenador;
        this.nombreCompleto = nombreCompleto;
    }

    public void actualizarEntrenadorZona(EntrenadorZonaId entrenadorZonaId,
                    ZonaDeTrabajo zonaDeTrabajo, Telefono telefono, Email email, NombreCompleto nombreCompleto){

        this.entrenadorZonaId = EntrenadorZonaId.of(entrenadorZonaId.value());
        this.email = Email.of(email.value());
        this.nombreCompleto = NombreCompleto.of(nombreCompleto.value());
        this.telefono = Telefono.of(telefono.value());
        this.zonaDeTrabajo = ZonaDeTrabajo.of(zonaDeTrabajo.value());
    }
}
