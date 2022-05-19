package co.com.bodytech.entrenamiento.entrenador;

import co.com.bodytech.entrenamiento.cliente.values.TipoDeCliente;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Entrenador extends AggregateEvent<EntrenadorId> {

    protected EntrenadorZonaId entrenadorZonaId;
    protected EntrenadorGeneralId entrenadorGeneralId;
    protected EntrenadorPersonalizadoId entrenadorPersonalizadoId;
    protected TipoDeEntrenador tipoDeEntrenador;
    protected NombreCompleto nombreCompleto;


    public Entrenador(EntrenadorId EntrenadorId) {
        super(EntrenadorId);
        subscribe(new EntrenadorEventChange(this));
    }

    public Entrenador(EntrenadorId EntrenadorId, EntrenadorZonaId entrenadorZonaId,
                      TipoDeEntrenador tipoDeEntrenador, NombreCompleto nombreCompleto) {

        super(EntrenadorId);
        this.entrenadorZonaId = entrenadorZonaId;
        this.tipoDeEntrenador = tipoDeEntrenador;
        this.nombreCompleto = nombreCompleto;
    }

    public Entrenador(EntrenadorId EntrenadorId, EntrenadorGeneralId entrenadorGeneralId,
                      TipoDeEntrenador tipoDeEntrenador, NombreCompleto nombreCompleto) {

        super(EntrenadorId);
        this.entrenadorGeneralId = entrenadorGeneralId;
        this.tipoDeEntrenador = tipoDeEntrenador;
        this.nombreCompleto = nombreCompleto;
    }

    public Entrenador(EntrenadorId EntrenadorId, EntrenadorPersonalizadoId entrenadorPersonalizadoId,
                      TipoDeEntrenador tipoDeEntrenador, NombreCompleto nombreCompleto) {

        super(EntrenadorId);
        this.entrenadorPersonalizadoId = entrenadorPersonalizadoId;
        this.tipoDeEntrenador = tipoDeEntrenador;
        this.nombreCompleto = nombreCompleto;
    }

    public static Entrenador from(EntrenadorId entrenadorId, List<DomainEvent> events){
        var entrenador = new Entrenador(entrenadorId);
        events.forEach(entrenador::applyEvent);
        return entrenador;
    }

}
