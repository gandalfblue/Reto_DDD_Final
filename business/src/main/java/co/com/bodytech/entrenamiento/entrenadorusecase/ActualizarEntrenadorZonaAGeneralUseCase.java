package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.entrenador.Entrenador;
import co.com.bodytech.entrenamiento.entrenador.commands.ActualizarEntrenadorZonaAGeneral;
import co.com.bodytech.entrenamiento.services.ConsultarEntrenadorZona;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarEntrenadorZonaAGeneralUseCase extends UseCase<RequestCommand<ActualizarEntrenadorZonaAGeneral>,
        ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ActualizarEntrenadorZonaAGeneral> actualizarEntrenadorZonaAGeneralRequestCommand) {

        var command = actualizarEntrenadorZonaAGeneralRequestCommand.getCommand();
        var entrenadorZonaService = getService(ConsultarEntrenadorZona.class).orElseThrow();

        var entrenador = Entrenador.from(command.getEntrenadorId(),
                repository().getEventsBy(command.getEntrenadorId().value()));

        entrenador.actualizarEntrenadorZonaAGeneral(
                entrenadorZonaService.consultarPorEntrenadorZonaId(command.getEntrenadorZonaId()),
                command.getTelefono(), command.getEmail(),command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(entrenador.getUncommittedChanges()));
    }
}
