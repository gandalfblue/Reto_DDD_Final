package co.com.bodytech.entrenamiento.entrenadorusecasetest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.entrenador.commands.CrearEntrenadorZona;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorZonaCreado;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorZonaId;
import co.com.bodytech.entrenamiento.entrenadorusecase.CrearEntrenadorZonaUseCase;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearEntrenadorZonaUseCaseTest {

    private CrearEntrenadorZonaUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearEntrenadorZonaUseCase();
    }

    @Test
    public void crearEntrenadorZonaHappyPass(){

        //arrange
        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var entrenadorId = EntrenadorId.of("10");
        var entrenadorZonaId = EntrenadorZonaId.of("E10");
        var nombreCompleto = NombreCompleto.of("Julian");
        var command = new CrearEntrenadorZona(centroAcondicionamientoId, entrenadorId, entrenadorZonaId,
                                                        nombreCompleto);

        //act
        var eventos = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var entrenadorZonaCreado = (EntrenadorZonaCreado)eventos.get(0);
        Assertions.assertEquals("10", entrenadorZonaCreado.aggregateRootId());
        Assertions.assertEquals("Julian", entrenadorZonaCreado.getNombreCompleto().value());
        Assertions.assertEquals("E10", entrenadorZonaCreado.getEntrenadorZonaId().value());
    }

}