package co.com.bodytech.entrenamiento.centroacondicionamiento;

import co.com.bodytech.entrenamiento.centroacondicionamiento.events.AprendizActualizado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.AprendizCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.AprendizEliminado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.CentroAcondicionamientoCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.MaquinaCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.TipoMaquinaActualizado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.TipoZonaActualizado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.ZonaCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.AprendizId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.MaquinaId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class CentroAcondicionamiento extends AggregateEvent<CentroAcondicionamientoId> {

    protected CentroAcondicionamientoId centroAcondicionamientoId;
    protected Zona zona;
    protected ZonaId zonaId;
    protected Maquina maquina;
    protected MaquinaId maquinaId;
    protected AprendizId aprendizId;
    protected Aprendiz aprendiz;
    protected NombreCompleto nombreCompleto;

    public CentroAcondicionamiento(CentroAcondicionamientoId centroAcondicionamientoId) {
        super(centroAcondicionamientoId);
        subscribe(new CentroAcondicionamientoChange(this));
    }

    public CentroAcondicionamiento(CentroAcondicionamientoId centroAcondicionamientoId,
                                                                NombreCompleto nombreCompleto) {
        super(centroAcondicionamientoId);

        var maquinaId = new MaquinaId();
        var zonaId = new ZonaId();
        var aprendizId = new AprendizId();

        appendChange(new CentroAcondicionamientoCreado(zonaId, maquinaId, aprendizId, nombreCompleto)).apply();
        subscribe(new CentroAcondicionamientoChange(this));
    }

    public void crearAprendiz(CentroAcondicionamientoId centroAcondicionamientoId,
                              Telefono telefono, NombreCompleto nombreCompleto) {

        var aprendizId = new AprendizId();
        appendChange(new AprendizCreado(aprendizId, telefono, nombreCompleto)).apply();
        subscribe(new CentroAcondicionamientoChange(this));
    }

    public void crearMaquina(CentroAcondicionamientoId centroAcondicionamientoId) {

        var maquinaId = new MaquinaId();

        appendChange(new MaquinaCreado(centroAcondicionamientoId, maquinaId)).apply();
        subscribe(new CentroAcondicionamientoChange(this));
    }

    public void crearZona(CentroAcondicionamientoId centroAcondicionamientoId) {

        var zonaId = new ZonaId();

        appendChange(new ZonaCreado(centroAcondicionamientoId, zonaId)).apply();
        subscribe(new CentroAcondicionamientoChange(this));
    }

    public static CentroAcondicionamiento from(CentroAcondicionamientoId centroAcondicionamientoId,
                                               List<DomainEvent> eventos){

        var centroAcondicionamiento = new CentroAcondicionamiento(centroAcondicionamientoId);
        eventos.forEach(centroAcondicionamiento::applyEvent);
        return centroAcondicionamiento;
    }

    public void actualizarTipoMaquinaAFuerza(MaquinaId maquinaId){

        appendChange(new TipoMaquinaActualizado(maquinaId)).apply();
    }

    public void actualizarTipoZonaACardio(ZonaId zonaId){

        appendChange(new TipoZonaActualizado(zonaId)).apply();
    }

    public void actualizarAprendiz(AprendizId aprendizId, Telefono telefono,
                                    Email email, NombreCompleto nombreCompleto){

        appendChange(new AprendizActualizado(aprendizId, telefono, email, nombreCompleto)).apply();
    }

    public void eliminarAprendiz(){
        appendChange(new AprendizEliminado()).apply();
    }

    public CentroAcondicionamientoId centroAcondicionamientoId() {
        return centroAcondicionamientoId;
    }

    public Zona getZona() {
        return zona;
    }

    public ZonaId getZonaId() {
        return zonaId;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public MaquinaId getMaquinaId() {
        return maquinaId;
    }

    public AprendizId getAprendizId() {
        return aprendizId;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }
}
