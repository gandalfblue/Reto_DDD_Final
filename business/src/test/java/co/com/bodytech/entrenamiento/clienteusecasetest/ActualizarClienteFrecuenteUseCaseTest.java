package co.com.bodytech.entrenamiento.clienteusecasetest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.commands.ActualizarClienteFrecuente;
import co.com.bodytech.entrenamiento.cliente.events.ClienteFrecuenteActualizado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteFrecuenteCreado;
import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.clienteusecase.ActualizarClienteFrecuenteUseCase;
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
class ActualizarClienteFrecuenteUseCaseTest {

    @InjectMocks
    private ActualizarClienteFrecuenteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarClienteVIPHappyPass(){

        //arrange
        var clienteId = ClienteId.of("12");
        var clienteFrecuenteId = ClienteFrecuenteId.of("CF12");
        var telefono = Telefono.of("123456789");
        var email = Email.of("julian@sofkau.comco");
        var nombreCompleto = NombreCompleto.of("Julian");
        var command = new ActualizarClienteFrecuente(clienteId, clienteFrecuenteId,
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
        var clienteFrecuenteActualizado = (ClienteFrecuenteActualizado)eventos.get(0);
        Assertions.assertEquals("12", clienteFrecuenteActualizado.aggregateRootId());
        Assertions.assertEquals("Julian", clienteFrecuenteActualizado.getNombreCompleto().value());
        Assertions.assertEquals("CF12", clienteFrecuenteActualizado.getClienteFrecuenteId().value());
    }

    private List<DomainEvent> history() {

        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var clienteFrecuenteId = ClienteFrecuenteId.of("CF12");
        var nombreCompleto = NombreCompleto.of("Andres");
        var evento = new ClienteFrecuenteCreado(
                centroAcondicionamientoId,
                clienteFrecuenteId,
                nombreCompleto
                );
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }

}