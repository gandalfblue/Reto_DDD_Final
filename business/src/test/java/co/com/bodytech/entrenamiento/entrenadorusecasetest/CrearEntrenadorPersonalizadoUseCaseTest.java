package co.com.bodytech.entrenamiento.entrenadorusecasetest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.entrenador.commands.CrearEntrenadorPersonalizado;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorPersonalizadoCreado;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorPersonalizadoId;
import co.com.bodytech.entrenamiento.entrenadorusecase.CrearEntrenadorPersonalizadoUseCase;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearEntrenadorPersonalizadoUseCaseTest {

    private CrearEntrenadorPersonalizadoUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearEntrenadorPersonalizadoUseCase();
    }

    @Test
    public void crearEntrenadorGeneralHappyPass(){

        //arrange
        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var entrenadorId = EntrenadorId.of("10");
        var entrenadorPersonalizadoId = EntrenadorPersonalizadoId.of("E10");
        var nombreCompleto = NombreCompleto.of("Julian");
        var command = new CrearEntrenadorPersonalizado(centroAcondicionamientoId, entrenadorId,
                                    entrenadorPersonalizadoId, nombreCompleto);

        //act
        var eventos = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var entrenadorPersonalizadoCreado = (EntrenadorPersonalizadoCreado)eventos.get(0);
        Assertions.assertEquals("10", entrenadorPersonalizadoCreado.aggregateRootId());
        Assertions.assertEquals("Julian", entrenadorPersonalizadoCreado.getNombreCompleto().value());
        Assertions.assertEquals("E10",
                                    entrenadorPersonalizadoCreado.getEntrenadorPersonalizadolId().value());
    }
}