package co.com.bodytech.entrenamiento.entrenador;

import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorGeneralActualizado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorPersonalizadoActualizado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaEliminado;
import co.com.bodytech.entrenamiento.entrenador.values.CantidadDeClientes;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorGeneralId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorPersonalizadoId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaActualizado;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.bodytech.entrenamiento.entrenador.values.TipoDeEntrenador;
import co.com.bodytech.entrenamiento.entrenador.values.ZonaDeTrabajo;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Entrenador extends AggregateEvent<EntrenadorId> {

    protected EntrenadorZonaId entrenadorZonaId;
    protected EntrenadorZona entrenadorZona;
    protected EntrenadorGeneralId entrenadorGeneralId;
    protected EntrenadorGeneral entrenadorGeneral;
    protected EntrenadorPersonalizadoId entrenadorPersonalizadoId;
    protected EntrenadorPersonalizado entrenadorPersonalizado;
    protected TipoDeEntrenador tipoDeEntrenador;
    protected NombreCompleto nombreCompleto;

    public Entrenador(EntrenadorId EntrenadorId) {
        super(EntrenadorId);
        subscribe(new EntrenadorEventChange(this));
    }

    public Entrenador(EntrenadorId EntrenadorId, EntrenadorZonaId entrenadorZonaId,
                            NombreCompleto nombreCompleto) {

        super(EntrenadorId);
        this.entrenadorZonaId = entrenadorZonaId;
        this.nombreCompleto = nombreCompleto;
    }

    public Entrenador(EntrenadorId EntrenadorId, EntrenadorGeneralId entrenadorGeneralId,
                                 NombreCompleto nombreCompleto) {

        super(EntrenadorId);
        this.entrenadorGeneralId = entrenadorGeneralId;
        this.nombreCompleto = nombreCompleto;
    }

    public Entrenador(EntrenadorId EntrenadorId, EntrenadorPersonalizadoId entrenadorPersonalizadoId,
                                 NombreCompleto nombreCompleto) {

        super(EntrenadorId);
        this.entrenadorPersonalizadoId = entrenadorPersonalizadoId;
        this.nombreCompleto = nombreCompleto;
    }

    public static Entrenador from(EntrenadorId entrenadorId, List<DomainEvent> events){
        var entrenador = new Entrenador(entrenadorId);
        events.forEach(entrenador::applyEvent);
        return entrenador;
    }

    public void actualizarEntrenadorGeneral(EntrenadorGeneralId entrenadorGeneralId, Telefono telefono,
                                            Email email, NombreCompleto nombreCompleto){
        appendChange(new EntrenadorGeneralActualizado(entrenadorGeneralId,
                telefono, email, nombreCompleto)).apply();
    }

    public void actualizarEntrenadorPersonalizado(EntrenadorPersonalizadoId EntrenadorPersonalizadoId,
                                                  CantidadDeClientes cantidadDeClientes, Telefono telefono, Email email, NombreCompleto nombreCompleto){
        appendChange(new EntrenadorPersonalizadoActualizado(EntrenadorPersonalizadoId, cantidadDeClientes,
                telefono, email, nombreCompleto)).apply();
    }

    public void actualizarEntrenadorZona(EntrenadorZonaId entrenadorZonaId,
                                         ZonaDeTrabajo zonaDeTrabajo, Telefono telefono, Email email, NombreCompleto nombreCompleto){

        appendChange(new EntrenadorZonaActualizado(entrenadorZonaId, zonaDeTrabajo, telefono,
                                                    email, nombreCompleto)).apply();
    }

    public void eliminarEntrenadorZona(){
        appendChange(new EntrenadorZonaEliminado()).apply();
    }
}
