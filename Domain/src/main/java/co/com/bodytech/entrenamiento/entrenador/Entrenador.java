package co.com.bodytech.entrenamiento.entrenador;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.genericos.Email;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorGeneralActualizado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorGeneralCreado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorPersonalizadoActualizado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorPersonalizadoCreado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaActualizado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaCambiadoAGeneral;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaCreado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaEliminado;
import co.com.bodytech.entrenamiento.entrenador.values.CantidadDeClientes;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorGeneralId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorPersonalizadoId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.bodytech.entrenamiento.entrenador.values.TipoDeEntrenador;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Entrenador extends AggregateEvent<EntrenadorId> {

    protected CentroAcondicionamientoId centroAcondicionamientoId;
    protected EntrenadorId entrenadorId;
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

    public Entrenador(CentroAcondicionamientoId centroAcondicionamientoId, EntrenadorId entrenadorId,
                      EntrenadorZonaId entrenadorZonaId, NombreCompleto nombreCompleto) {

        super(entrenadorId);
        appendChange(new EntrenadorZonaCreado(centroAcondicionamientoId, entrenadorId,
                                                    entrenadorZonaId, nombreCompleto)).apply();
        subscribe(new EntrenadorEventChange(this));
    }

    public Entrenador(CentroAcondicionamientoId centroAcondicionamientoId, EntrenadorId entrenadorId,
                                EntrenadorGeneralId entrenadorGeneralId, NombreCompleto nombreCompleto) {

        super(entrenadorId);
        appendChange(new EntrenadorGeneralCreado(centroAcondicionamientoId, entrenadorId,
                                                entrenadorGeneralId, nombreCompleto)).apply();
        subscribe(new EntrenadorEventChange(this));
    }

    public Entrenador(CentroAcondicionamientoId centroAcondicionamientoId, EntrenadorId entrenadorId,
                            EntrenadorPersonalizadoId entrenadorPersonalizadoId, NombreCompleto nombreCompleto) {

        super(entrenadorId);
        appendChange(new EntrenadorPersonalizadoCreado(centroAcondicionamientoId, entrenadorId,
                                                entrenadorPersonalizadoId, nombreCompleto)).apply();
        subscribe(new EntrenadorEventChange(this));
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

    public void actualizarEntrenadorPersonalizado(EntrenadorPersonalizadoId entrenadorPersonalizadoId,
                                                    CantidadDeClientes cantidadDeClientes, Telefono telefono,
                                                    Email email, NombreCompleto nombreCompleto){
        appendChange(new EntrenadorPersonalizadoActualizado(entrenadorPersonalizadoId, cantidadDeClientes,
                telefono, email, nombreCompleto)).apply();
    }

    public void actualizarEntrenadorZona(EntrenadorZonaId entrenadorZonaId,
                                         Telefono telefono, Email email, NombreCompleto nombreCompleto){

        appendChange(new EntrenadorZonaActualizado(entrenadorZonaId, telefono, email, nombreCompleto)).apply();
    }

    public void actualizarEntrenadorZonaAGeneral(EntrenadorZonaId entrenadorZonaId, Telefono telefono,
                                                    Email email, NombreCompleto nombreCompleto){

        var entrenadorGeneralId = new EntrenadorGeneralId();

        appendChange(new EntrenadorZonaCambiadoAGeneral(entrenadorId, entrenadorZonaId,
                entrenadorGeneralId, telefono, email, nombreCompleto)).apply();
    }

    public void eliminarEntrenadorZona(EntrenadorZonaId entrenadorZonaId){

        appendChange(new EntrenadorZonaEliminado(entrenadorZonaId, entrenadorId)).apply();
    }
}
