package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.entrenador.commands.ActualizarEntrenadorGeneral;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorGeneralActualizado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorGeneralCreado;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorGeneralId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
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
class ActualizarEntrenadorGeneralUseCaseTest {

    @InjectMocks
    private ActualizarEntrenadorGeneralUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarEntrenadorGeneralHappyPass(){

        //arrange
        var entrenadorId = EntrenadorId.of("10");
        var entrenadorGeneralId = EntrenadorGeneralId.of("E12");
        var telefono = Telefono.of("123456789");
        var email = Email.of("julian@sofkau.comco");
        var nombreCompleto = NombreCompleto.of("Julian");
        var command = new ActualizarEntrenadorGeneral(entrenadorId, entrenadorGeneralId,
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
        var entrenadorGeneralActualizado = (EntrenadorGeneralActualizado)eventos.get(0);
        Assertions.assertEquals("10", entrenadorGeneralActualizado.aggregateRootId());
        Assertions.assertEquals("Julian", entrenadorGeneralActualizado.getNombreCompleto().value());
        Assertions.assertEquals("E12", entrenadorGeneralActualizado.getEntrenadorGeneralId().value());
    }

    private List<DomainEvent> history() {

        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var entrenadorId = EntrenadorId.of("10");
        var entrenadorGeneralId = EntrenadorGeneralId.of("E12");
        var nombreCompleto = NombreCompleto.of("Andres");
        var evento = new EntrenadorGeneralCreado(
                centroAcondicionamientoId, entrenadorId,
                entrenadorGeneralId,
                nombreCompleto
        );
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }
}