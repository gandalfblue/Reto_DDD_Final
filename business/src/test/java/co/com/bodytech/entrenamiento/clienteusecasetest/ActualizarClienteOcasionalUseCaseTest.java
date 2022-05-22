package co.com.bodytech.entrenamiento.clienteusecasetest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.commands.ActualizarClienteOcasional;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalActualizado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalCreado;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.genericos.Email;
import co.com.bodytech.entrenamiento.clienteusecase.ActualizarClienteOcasionalUseCase;
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
class ActualizarClienteOcasionalUseCaseTest {

    @InjectMocks
    private ActualizarClienteOcasionalUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarClienteOcasionalHappyPass(){

        //arrange
        var clienteId = ClienteId.of("12");
        var clienteOcasionalId = ClienteOcasionalId.of("CF12");
        var telefono = Telefono.of("123456789");
        var email = Email.of("julian@sofkau.comco");
        var nombreCompleto = NombreCompleto.of("Julian");
        var command = new ActualizarClienteOcasional(clienteId, clienteOcasionalId,
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
        var clienteOcasionalActualizado = (ClienteOcasionalActualizado)eventos.get(0);
        Assertions.assertEquals("12", clienteOcasionalActualizado.aggregateRootId());
        Assertions.assertEquals("Julian", clienteOcasionalActualizado.getNombreCompleto().value());
        Assertions.assertEquals("CF12", clienteOcasionalActualizado.getClienteOcasionalId().value());


    }

    private List<DomainEvent> history() {

        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var clienteOcasionalId = ClienteOcasionalId.of("CF10");
        var nombreCompleto = NombreCompleto.of("Andres");
        var evento = new ClienteOcasionalCreado(
                centroAcondicionamientoId,
                clienteOcasionalId,
                nombreCompleto);
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }
}