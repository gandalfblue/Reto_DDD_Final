package co.com.bodytech.entrenamiento.clienteusecasetest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.commands.ActualizarMembresiaClienteOcasional;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalCreado;
import co.com.bodytech.entrenamiento.cliente.events.MembresiaClienteOcasionalActualizado;
import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.genericos.Email;
import co.com.bodytech.entrenamiento.clienteusecase.ActualizarMembresiaClienteOcasionalUseCase;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.bodytech.entrenamiento.services.ConsultarClienteOcasional;
import co.com.sofka.business.generic.ServiceBuilder;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarMembresiaClienteOcasionalUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Mock
    private ConsultarClienteOcasional service;

    @InjectMocks
    private ActualizarMembresiaClienteOcasionalUseCase useCase;

    @Test
    void actualizarMembresiaClienteOcasional(){

        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var clienteId = ClienteId.of("12");
        var clienteFrecuenteId = ClienteFrecuenteId.of("CF10");
        var clienteOcasionalId = ClienteOcasionalId.of("CO12");
        var telefono = Telefono.of("123456789");
        var email = Email.of("julian@sofkau.comco");
        var nombreCompleto = NombreCompleto.of("Julian");
        var command = new ActualizarMembresiaClienteOcasional(clienteOcasionalId, centroAcondicionamientoId,
                                                    clienteId, clienteFrecuenteId, telefono, email, nombreCompleto);

        when(repository.getEventsBy("12")).thenReturn(history());
        when(service.consultarPorClienteOcasionalId(any(ClienteOcasionalId.class))).thenReturn(clienteOcasionalId);
        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var membresiaClienteOcasionalCambiada = (MembresiaClienteOcasionalActualizado)events.get(0);
        Assertions.assertEquals("Julian", membresiaClienteOcasionalCambiada.getNombreCompleto().value());
        Assertions.assertEquals("julian@sofkau.comco", membresiaClienteOcasionalCambiada.getEmail().value());
        Assertions.assertEquals("123456789", membresiaClienteOcasionalCambiada.getTelefono().value());
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