package co.com.bodytech.entrenamiento.entrenadorusecase;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.entrenador.commands.CrearEntrenadorGeneral;
import co.com.bodytech.entrenamiento.entrenador.events.EntrenadorGeneralCreado;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorGeneralId;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorId;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearEntrenadorGeneralUseCaseTest {

    private CrearEntrenadorGeneralUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearEntrenadorGeneralUseCase();
    }

    @Test
    public void crearEntrenadorGeneralHappyPass(){

        //arrange
        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var entrenadorId = EntrenadorId.of("10");
        var entrenadorGeneralId = EntrenadorGeneralId.of("E10");
        var nombreCompleto = NombreCompleto.of("Julian");
        var command = new CrearEntrenadorGeneral(centroAcondicionamientoId, entrenadorId, entrenadorGeneralId, nombreCompleto);

        //act
        var eventos = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var entrenadorGeneralCreado = (EntrenadorGeneralCreado)eventos.get(0);
        Assertions.assertEquals("10", entrenadorGeneralCreado.aggregateRootId());
        Assertions.assertEquals("Julian", entrenadorGeneralCreado.getNombreCompleto().value());
        Assertions.assertEquals("E10", entrenadorGeneralCreado.getEntrenadorGeneralId().value());
    }
}