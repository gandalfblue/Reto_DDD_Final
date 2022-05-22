package co.com.bodytech.entrenamiento.entrenadorusecasetest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.values.Email;
import co.com.bodytech.entrenamiento.entrenador.commands.ActualizarEntrenadorZonaAGeneral;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaCambiadoAGeneral;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaCreado;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorGeneralId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.bodytech.entrenamiento.entrenadorusecase.ActualizarEntrenadorZonaAGeneralUseCase;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.bodytech.entrenamiento.services.ConsultarEntrenadorZona;
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
class ActualizarEntrenadorZonaAGeneralUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Mock
    private ConsultarEntrenadorZona service;

    @InjectMocks
    private ActualizarEntrenadorZonaAGeneralUseCase useCase;

    @Test
    void actualizarEntrenadorZonaAGeneral(){

        var entrenadorId = EntrenadorId.of("E15");
        var entrenadorZonaId = EntrenadorZonaId.of("EZ10");
        var entrenadorGeneralId = EntrenadorGeneralId.of("E12");
        var telefono = Telefono.of("123456789");
        var email = Email.of("julian@sofkau.comco");
        var nombreCompleto = NombreCompleto.of("Julian");
        var command = new ActualizarEntrenadorZonaAGeneral(entrenadorId, entrenadorZonaId,
        entrenadorGeneralId, telefono, email, nombreCompleto);

        when(repository.getEventsBy("E15")).thenReturn(history());
        when(service.consultarPorEntrenadorZonaId(any(EntrenadorZonaId.class))).thenReturn(entrenadorZonaId);
        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var entrenadorZonaCambiado = (EntrenadorZonaCambiadoAGeneral)events.get(0);
        Assertions.assertEquals("Julian", entrenadorZonaCambiado.getNombreCompleto().value());
        Assertions.assertEquals("julian@sofkau.comco", entrenadorZonaCambiado.getEmail().value());
        Assertions.assertEquals("123456789", entrenadorZonaCambiado.getTelefono().value());
    }

    private List<DomainEvent> history() {

        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var entrenadorId = EntrenadorId.of("E10");
        var entrenadorZonaId = EntrenadorZonaId.of("EZ12");
        var nombreCompleto = NombreCompleto.of("Andres");
        var evento = new EntrenadorZonaCreado(
                centroAcondicionamientoId,
                entrenadorId,
                entrenadorZonaId,
                nombreCompleto
        );
        evento.setAggregateRootId("Root");
        return List.of(evento);
    }
}