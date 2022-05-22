package co.com.bodytech.entrenamiento.centroacondicionamientousecaseTest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.commands.ActualizarTipoZona;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.TipoZonaActualizado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.ZonaCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.bodytech.entrenamiento.centroacondicionamientousecase.ActualizarTipoZonaUseCase;
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
class ActualizarTipoZonaUseCaseTest {

    @InjectMocks
    private ActualizarTipoZonaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarTipoZonaHappyPass(){

        //arrange
        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var zonaId = ZonaId.of("Z02");
        var command = new ActualizarTipoZona(centroAcondicionamientoId, zonaId);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var eventos = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getZonaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var zonaActualizado = (TipoZonaActualizado)eventos.get(0);
        Assertions.assertEquals("1", zonaActualizado.aggregateRootId());
        Assertions.assertEquals("Z02", zonaActualizado.getZonaId().value());
    }

    private List<DomainEvent> history() {

        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var zonaId = ZonaId.of("A10");
        var evento = new ZonaCreado(
                centroAcondicionamientoId,
                zonaId
        );
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }
}