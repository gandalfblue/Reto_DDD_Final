package co.com.bodytech.entrenamiento.clienteusecasetest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.commands.EliminarClienteOcasional;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalEliminado;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.clienteusecase.EliminarClienteOcasionalUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EliminarClienteOcasionalUseCaseTest {

    @InjectMocks
    private EliminarClienteOcasionalUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void eliminarClienteOcasionalUseCaseHappyPass(){

        //arrange
        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var clienteId = ClienteId.of("12");
        var command = new EliminarClienteOcasional(clienteId, centroAcondicionamientoId );
        //when(repository.getEventsBy("12")).thenReturn();
        useCase.addRepository(repository);

        //act
        var eventos = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var clienteOcasionalEliminado = (ClienteOcasionalEliminado)eventos.get(0);
        Assertions.assertEquals("12", clienteOcasionalEliminado.aggregateRootId());
    }

    /*private List<DomainEvent> history() {
        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var clienteId = ClienteId.of("12");
        var clienteOcasionalId = ClienteOcasionalId.of("CF12");
        var nombreCompleto = NombreCompleto.of("Julian");
        var clienteOcasional = new CrearClienteOcasional(
                clienteId,
                centroAcondicionamientoId,
                clienteOcasionalId,
                nombreCompleto);
        clienteOcasional.setAggregateRootId("12");
        return List.of(clienteOcasional);
    }*/
}