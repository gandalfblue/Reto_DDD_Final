package co.com.bodytech.entrenamiento.centroacondicionamiento;

import co.com.bodytech.entrenamiento.centroacondicionamiento.events.AprendizActualizado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.AprendizEliminado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.CentroAcondicionamientoCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.TipoMaquinaActualizado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.TipoZonaActualizado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.AprendizId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.MaquinaId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.bodytech.entrenamiento.cliente.Cliente;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.entrenador.Entrenador;
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

    public CentroAcondicionamiento(CentroAcondicionamientoId centroAcondicionamientoId) {
        super(centroAcondicionamientoId);
        subscribe(new CentroAcondicionamientoChange(this));
    }

    public CentroAcondicionamiento(CentroAcondicionamientoId centroAcondicionamientoId,
           Cliente cliente, Entrenador entrenador, Zona zona, Maquina maquina, Aprendiz aprendiz) {

        super(centroAcondicionamientoId);
        appendChange(new CentroAcondicionamientoCreado(zona, zonaId, maquina, maquinaId, aprendiz, aprendizId)).apply();
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
