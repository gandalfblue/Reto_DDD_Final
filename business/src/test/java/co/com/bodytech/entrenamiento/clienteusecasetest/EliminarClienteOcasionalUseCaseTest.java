package co.com.bodytech.entrenamiento.clienteusecasetest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalCreado;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalEliminado;
import co.com.bodytech.entrenamiento.cliente.events.MembresiaClienteOcasionalActualizado;
import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.clienteusecase.EliminarClienteOcasionalUseCase;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
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
class EliminarClienteOcasionalUseCaseTest {

    @InjectMocks
    private EliminarClienteOcasionalUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void eliminarClienteOcasionalUseCaseHappyPass(){

        //arrange
        var clienteOcasionalId = ClienteOcasionalId.of("CO12");
        var clienteId = ClienteId.of("15");
        var clienteFrecuenteId = ClienteFrecuenteId.of("CF12");
        var telefono = Telefono.of("123456789");
        var email = Email.of("julian@sofkau.comco");
        var nombreCompleto = NombreCompleto.of("Julian");
        var evento = new MembresiaClienteOcasionalActualizado(clienteId, clienteOcasionalId,
                clienteFrecuenteId, telefono, email, nombreCompleto);

        when(repository.getEventsBy("15")).thenReturn(history());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(evento))
                .orElseThrow()
                .getDomainEvents();

        var clienteOcacionalEliminado = (ClienteOcasionalEliminado)events.get(0);
        Assertions.assertEquals("CO12",clienteOcacionalEliminado.getClienteOcasionalId().value());
    }

    private List<DomainEvent> history() {

        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var clienteOcasionalId = ClienteOcasionalId.of("CO10");
        var nombreCompleto = NombreCompleto.of("Andres");
        var event = new ClienteOcasionalCreado(
                centroAcondicionamientoId,
                clienteOcasionalId,
                nombreCompleto);
        event.setAggregateRootId("Root");
        return List.of(event);
    }
}