package co.com.bodytech.entrenamiento.entrenador;

import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorGeneralActualizado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorGeneralCreado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorPersonalizadoActualizado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorPersonalizadoCreado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaActualizado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaCambiadoAGeneral;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaCreado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaEliminado;
import co.com.bodytech.entrenamiento.entrenador.values.TipoDeEntrenador;
import co.com.bodytech.entrenamiento.entrenador.values.ZonaDeTrabajo;
import co.com.sofka.domain.generic.EventChange;

public class EntrenadorEventChange extends EventChange {
    public EntrenadorEventChange(Entrenador entrenador) {

        apply((EntrenadorZonaCreado evento) ->{
            entrenador.nombreCompleto = evento.getNombreCompleto();
            entrenador.entrenadorZona = new EntrenadorZona(evento.getEntrenadorZonaId(),
                    new TipoDeEntrenador(TipoDeEntrenador.Tipo.Entrenador_Zona),
                    evento.getNombreCompleto());
        });

        apply((EntrenadorGeneralCreado evento) ->{
            entrenador.nombreCompleto = evento.getNombreCompleto();
            entrenador.entrenadorGeneral = new EntrenadorGeneral(evento.getEntrenadorGeneralId(),
                    new TipoDeEntrenador(TipoDeEntrenador.Tipo.Entrenador_General),
                    evento.getNombreCompleto());
        });

        apply((EntrenadorPersonalizadoCreado evento) ->{
            entrenador.nombreCompleto = evento.getNombreCompleto();
            entrenador.entrenadorPersonalizado =
                    new EntrenadorPersonalizado( evento.getEntrenadorPersonalizadolId(),
                    new TipoDeEntrenador(TipoDeEntrenador.Tipo.Entrenador_Personalizado),
                    evento.getNombreCompleto());
        });

        apply((EntrenadorZonaCambiadoAGeneral evento)->{

            var entrenadorGeneralId = evento.getEntrenadorGeneralId();
            var telefono = evento.getTelefono();
            var nombreCompleto = evento.getNombreCompleto();
            var email = evento.getEmail();

            entrenador.entrenadorGeneral = new EntrenadorGeneral(entrenadorGeneralId,
                    telefono,email,nombreCompleto);
        });

        apply((EntrenadorGeneralActualizado evento)->{

            var entrenadorGeneralId = evento.getEntrenadorGeneralId();
            var telefono = evento.getTelefono();
            var nombreCompleto = evento.getNombreCompleto();
            var email = evento.getEmail();

            entrenador.entrenadorGeneral.actualizarEntrenadorGeneral(entrenadorGeneralId,
                    telefono,email,nombreCompleto);
        });

        apply((EntrenadorPersonalizadoActualizado evento)->{

            var entrenadorPersonalizadoId = evento.getEntrenadorPersonalizadoId();
            var cantidadClientes = evento.getCantidadDeClientes();
            var telefono = evento.getTelefono();
            var nombreCompleto = evento.getNombreCompleto();
            var email = evento.getEmail();

            entrenador.entrenadorPersonalizado.actualizarEntrenadorPersonalizado(entrenadorPersonalizadoId,
                    cantidadClientes, telefono, email, nombreCompleto);
        });

        apply((EntrenadorZonaEliminado evento) ->{

            entrenador.entrenadorZona = null;

        });

        apply((EntrenadorZonaActualizado evento)->{

            var entrenadorZonaId = evento.getEntrenadorZonaId();

            var telefono = evento.getTelefono();
            var nombreCompleto = evento.getNombreCompleto();
            var email = evento.getEmail();

            entrenador.entrenadorZona.actualizarEntrenadorZona(entrenadorZonaId,
                    new ZonaDeTrabajo(ZonaDeTrabajo.Zona.Zona_Cardio), telefono, email, nombreCompleto);
        });
    }
}
