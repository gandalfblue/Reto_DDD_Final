package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.entrenador.Entrenador;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaCambiadoAGeneral;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class EliminarEntrenadorZonaUseCase extends UseCase<TriggeredEvent<EntrenadorZonaCambiadoAGeneral>,
        ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<EntrenadorZonaCambiadoAGeneral> entrenadorZonaCambiadoAGeneralTriggeredEvent) {

        var evento = entrenadorZonaCambiadoAGeneralTriggeredEvent.getDomainEvent();

        var entrenador = Entrenador.from(evento.getEntrenadorId(),
                repository().getEventsBy(evento.getEntrenadorId().value()));

        entrenador.eliminarEntrenadorZona(evento.getEntrenadorZonaId());

        emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));
    }
}
