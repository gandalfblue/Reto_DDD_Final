package co.com.bodytech.entrenamiento.entrenadorusecasetest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.genericos.Email;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaCambiadoAGeneral;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaCreado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaEliminado;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorGeneralId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.bodytech.entrenamiento.entrenadorusecase.EliminarEntrenadorZonaUseCase;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.bodytech.entrenamiento.services.ConsultarEntrenadorZona;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EliminarEntrenadorZonaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Mock
    private ConsultarEntrenadorZona service;

    @InjectMocks
    private EliminarEntrenadorZonaUseCase useCase;

    @Test
    void eliminarEntrenadorZonaCambiado(){

        var entrenadorId = EntrenadorId.of("E10");
        var entrenadorGeneralId = EntrenadorGeneralId.of("EG12");
        var entrenadorZonaId = EntrenadorZonaId.of("EZ02");
        var telefono = Telefono.of("123456789");
        var email = Email.of("julian@sofkau.comco");
        var nombreCompleto = NombreCompleto.of("Julian");
        var evento = new EntrenadorZonaCambiadoAGeneral(entrenadorId, entrenadorZonaId, entrenadorGeneralId,
                telefono,email, nombreCompleto);

        when(repository.getEventsBy("E10")).thenReturn(history());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(evento))
                .orElseThrow()
                .getDomainEvents();

        var entrenadorZonaCambiado = (EntrenadorZonaEliminado)events.get(0);
        //Assertions.assertEquals("EZ02", entrenadorZonaCambiado.getEntrenadorZonaId().value());
    }

    private List<DomainEvent> history() {

        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var entrenadorId = EntrenadorId.of("E10");
        var entrenadorZonaId = EntrenadorZonaId.of("EZ12");
        var nombreCompleto = NombreCompleto.of("Andres");
        var evento = new EntrenadorZonaCreado(
                centroAcondicionamientoId,
                entrenadorId,
                entrenadorZonaId,
                nombreCompleto
        );
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }
}