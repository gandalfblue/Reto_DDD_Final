package co.com.bodytech.entrenamiento.clienteusecasetest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.commands.ActualizarClienteVIP;
import co.com.bodytech.entrenamiento.cliente.events.ClienteVIPActualizado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteVIPCreado;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.genericos.Email;
import co.com.bodytech.entrenamiento.clienteusecase.ActualizarClienteVIPUseCase;
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
class ActualizarClienteVIPUseCaseTest {

    @InjectMocks
    private ActualizarClienteVIPUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarClienteVIPHappyPass(){

        //arrange
        var clienteId = ClienteId.of("12");
        var clienteVIPId = ClienteVIPId.of("CF12");
        var telefono = Telefono.of("123456789");
        var email = Email.of("julian@sofkau.comco");
        var nombreCompleto = NombreCompleto.of("Julian");
        var command = new ActualizarClienteVIP(clienteId, clienteVIPId,
                                                        telefono, email, nombreCompleto);

        when(repository.getEventsBy("12")).thenReturn(history());
        useCase.addRepository(repository);

        //act

        var eventos = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getClienteId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var clienteVIPActualizado = (ClienteVIPActualizado)eventos.get(0);
        Assertions.assertEquals("12", clienteVIPActualizado.aggregateRootId());
        Assertions.assertEquals("Julian", clienteVIPActualizado.getNombreCompleto().value());
        Assertions.assertEquals("CF12", clienteVIPActualizado.getClienteVIPId().value());
    }

    private List<DomainEvent> history() {

        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var clienteVIPId = ClienteVIPId.of("CF12");
        var nombreCompleto = NombreCompleto.of("Andres");
        var evento = new ClienteVIPCreado(
                centroAcondicionamientoId,
                nombreCompleto,
                clienteVIPId);
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }

}