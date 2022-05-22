package co.com.bodytech.entrenamiento.centroacondicionamientousecaseTest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.commands.ActualizarAprendiz;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.AprendizActualizado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.AprendizCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.AprendizId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.centroacondicionamientousecase.ActualizarAprendizUseCase;
import co.com.bodytech.entrenamiento.cliente.values.Email;
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
class ActualizarAprendizUseCaseTest {

    @InjectMocks
    private ActualizarAprendizUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarAprendizHappyPass(){

        //arrange
        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var aprendizId = AprendizId.of("A12");
        var telefono = Telefono.of("123456789");
        var email = Email.of("julian@sofkau.comco");
        var nombreCompleto = NombreCompleto.of("Julian");
        var command = new ActualizarAprendiz(centroAcondicionamientoId, aprendizId,
                telefono, email, nombreCompleto);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var eventos = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getAprendizId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var aprendizActualizado = (AprendizActualizado)eventos.get(0);
        Assertions.assertEquals("1", aprendizActualizado.aggregateRootId());
        Assertions.assertEquals("Julian", aprendizActualizado.getNombreCompleto().value());
        Assertions.assertEquals("A12", aprendizActualizado.getAprendizId().value());
    }

    private List<DomainEvent> history() {

        var aprendizId = AprendizId.of("A10");
        var telefono = Telefono.of("123456789");
        var nombreCompleto = NombreCompleto.of("Andres");
        var evento = new AprendizCreado(
                aprendizId,
                telefono,
                nombreCompleto
        );
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }
}