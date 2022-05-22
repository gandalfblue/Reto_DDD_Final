package co.com.bodytech.entrenamiento.centroacondicionamiento;

import co.com.bodytech.entrenamiento.centroacondicionamiento.events.AprendizCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.CentroAcondicionamientoCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.MaquinaCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.TipoMaquinaActualizado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.TipoZonaActualizado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.ZonaCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.AprendizId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.MaquinaId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.TipoDeZona;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.TipoMaquina;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.sofka.domain.generic.EventChange;

public class CentroAcondicionamientoChange extends EventChange {
    public CentroAcondicionamientoChange(CentroAcondicionamiento centroAcondicionamiento) {

        apply((CentroAcondicionamientoCreado evento) ->{

            centroAcondicionamiento.zonaId = evento.getZonaId();
            centroAcondicionamiento.aprendizId = evento.getAprendizId();
            centroAcondicionamiento.maquinaId = evento.getMaquinaId();
            centroAcondicionamiento.nombreCompleto = evento.getNombreCompleto();
            centroAcondicionamiento.zona = new Zona(evento.getZonaId());
            centroAcondicionamiento.maquina = new Maquina(evento.getMaquinaId());
            centroAcondicionamiento.aprendiz = new Aprendiz(evento.getAprendizId());
        });

        apply((AprendizCreado evento) ->{

            var aprendizID = new AprendizId();
            centroAcondicionamiento.aprendiz = new Aprendiz(aprendizID, evento.getTelefono(),
                                                                            evento.getNombreCompleto());
        });

        apply((MaquinaCreado evento) ->{

            var maquinaId = new MaquinaId();
            centroAcondicionamiento.maquina = new Maquina(maquinaId, new TipoMaquina(TipoMaquina.Tipo.Maquina_Cardio));
        });

        apply((ZonaCreado evento) ->{
            var zonaId = new ZonaId();
            centroAcondicionamiento.zona = new Zona(zonaId, new TipoDeZona(TipoDeZona.Tipo.Zona_Duchas));
        });

        apply((TipoMaquinaActualizado evento)->{

            var maquinaId = evento.getMaquinaId();

            centroAcondicionamiento.maquina.actualizarMaquina(maquinaId,
                                            new TipoMaquina(TipoMaquina.Tipo.Maquina_Fuerza));
        });

        apply((TipoZonaActualizado evento)->{

            var zonaId = evento.getZonaId();

            centroAcondicionamiento.zona.actualizarZona(zonaId,
                                                new TipoDeZona(TipoDeZona.Tipo.Zona_Cardio));
        });
    }
}
