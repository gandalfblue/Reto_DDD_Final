package co.com.bodytech.entrenamiento.centroacondicionamientousecaseTest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.commands.CrearCentroAcondicionamiento;
import co.com.bodytech.entrenamiento.centroacondicionamiento.events.CentroAcondicionamientoCreado;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.centroacondicionamientousecase.CrearCentroAcondicionamientoUseCase;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearCentroAcondicionamientoUseCaseTest {

    private CrearCentroAcondicionamientoUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearCentroAcondicionamientoUseCase();
    }

    @Test
    public void crearCentroAcondicionamientoHappyPass(){

        //arrange
        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var nombreCompleto = NombreCompleto.of("BodyTech Training");
        var command = new CrearCentroAcondicionamiento( centroAcondicionamientoId, nombreCompleto);

        //act
        var eventos = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var centroAcondicionamientoCreado = (CentroAcondicionamientoCreado)eventos.get(0);
        Assertions.assertEquals("1", centroAcondicionamientoCreado.aggregateRootId());
        Assertions.assertEquals("BodyTech Training",
                                        centroAcondicionamientoCreado.getNombreCompleto().value());
    }
}