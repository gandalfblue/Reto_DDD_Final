package co.com.bodytech.entrenamiento.centroacondicionamiento;

import co.com.bodytech.entrenamiento.centroacondicionamiento.events.AprendizEliminado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.CentroAcondicionamientoCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.TipoMaquinaActualizado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.TipoZonaActualizado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.TipoDeZona;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.TipoMaquina;
import co.com.sofka.domain.generic.EventChange;

public class CentroAcondicionamientoChange extends EventChange {
    public CentroAcondicionamientoChange(CentroAcondicionamiento centroAcondicionamiento) {

        apply((CentroAcondicionamientoCreado evento) ->{

            centroAcondicionamiento.aprendiz = new Aprendiz(evento.getAprendizId());
            centroAcondicionamiento.maquina = new Maquina(evento.getMaquinaId());
            centroAcondicionamiento.zona = new Zona(evento.getZonaId());
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

        apply((AprendizEliminado evento) ->{

            centroAcondicionamiento.aprendiz = null;

        });
    }
}
