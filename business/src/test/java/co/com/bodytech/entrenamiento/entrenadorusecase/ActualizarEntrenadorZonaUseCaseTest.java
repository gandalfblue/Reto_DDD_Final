package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.entrenador.commands.ActualizarEntrenadorZona;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaActualizado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaCreado;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarEntrenadorZonaUseCaseTest {

    @InjectMocks
    private ActualizarEntrenadorZonaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarEntrenadorZonaHappyPass(){

        //arrange
        var entrenadorId = EntrenadorId.of("10");
        var entrenadorZonaId = EntrenadorZonaId.of("E12");
        var telefono = Telefono.of("123456789");
        var email = Email.of("julian@sofkau.comco");
        var nombreCompleto = NombreCompleto.of("Julian");
        var command = new ActualizarEntrenadorZona(entrenadorId, entrenadorZonaId,
                telefono, email, nombreCompleto);

        when(repository.getEventsBy("10")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var eventos = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEntrenadorId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var entrenadorZonaActualizado = (EntrenadorZonaActualizado)eventos.get(0);
        Assertions.assertEquals("10", entrenadorZonaActualizado.aggregateRootId());
        Assertions.assertEquals("Julian", entrenadorZonaActualizado.
                getNombreCompleto().value());
        Assertions.assertEquals("E12", entrenadorZonaActualizado.getEntrenadorZonaId().value());
    }

    private List<DomainEvent> history() {

        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var entrenadorId = EntrenadorId.of("10");
        var entrenadorZonaId = EntrenadorZonaId.of("E12");
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