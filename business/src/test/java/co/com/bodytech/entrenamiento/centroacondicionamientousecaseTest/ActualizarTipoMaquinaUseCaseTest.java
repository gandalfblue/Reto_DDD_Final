package co.com.bodytech.entrenamiento.centroacondicionamientousecaseTest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.commands.ActualizarTipoMaquina;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.MaquinaCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.TipoMaquinaActualizado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.MaquinaId;
import co.com.bodytech.entrenamiento.centroacondicionamientousecase.ActualizarTipoMaquinaUseCase;
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
class ActualizarTipoMaquinaUseCaseTest {

    @InjectMocks
    private ActualizarTipoMaquinaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarTipoMaquinaHappyPass(){

        //arrange
        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var maaquinaId = MaquinaId.of("M10");
        var command = new ActualizarTipoMaquina(centroAcondicionamientoId, maaquinaId);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var eventos = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getMaquinaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var maquinaActualizado = (TipoMaquinaActualizado)eventos.get(0);
        Assertions.assertEquals("1", maquinaActualizado.aggregateRootId());
        Assertions.assertEquals("M10", maquinaActualizado.getMaquinaId().value());
    }

    private List<DomainEvent> history() {

        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var maquinaId = MaquinaId.of("A10");
        var evento = new MaquinaCreado(
                centroAcondicionamientoId,
                maquinaId
        );
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }
}