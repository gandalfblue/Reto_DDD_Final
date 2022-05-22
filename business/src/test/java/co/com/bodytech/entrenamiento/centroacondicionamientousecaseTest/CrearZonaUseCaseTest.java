package co.com.bodytech.entrenamiento.centroacondicionamientousecaseTest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.commands.CrearZona;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.CentroAcondicionamientoCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.ZonaCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.AprendizId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.MaquinaId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.bodytech.entrenamiento.centroacondicionamientousecase.CrearZonaUseCase;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
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
class CrearZonaUseCaseTest {


    @InjectMocks
    private CrearZonaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void crearZonaHappyPass(){

        //arrange
        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var zonaId = ZonaId.of("Z05");
        var command = new CrearZona( centroAcondicionamientoId, zonaId);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var eventos = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCentroAcondicionamientoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var zonaCreada = (ZonaCreado)eventos.get(0);
        Assertions.assertEquals("1", zonaCreada.aggregateRootId());
    }

    private List<DomainEvent> history() {

        var maquinaId = MaquinaId.of("M10");
        var nombreCompleto = NombreCompleto.of("BodyTech Training");
        var zonaId = ZonaId.of("Z02");
        var aprendizId = AprendizId.of("A05");
        var evento = new CentroAcondicionamientoCreado(
                zonaId,
                maquinaId,
                aprendizId,
                nombreCompleto
        );
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }
}