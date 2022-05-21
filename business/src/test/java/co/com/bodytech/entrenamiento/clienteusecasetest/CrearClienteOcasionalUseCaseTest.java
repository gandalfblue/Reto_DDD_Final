package co.com.bodytech.entrenamiento.clienteusecasetest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.commands.CrearClienteOcasional;
import co.com.bodytech.entrenamiento.cliente.events.ClienteOcasionalCreado;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteOcasionalId;
import co.com.bodytech.entrenamiento.clienteusecase.CrearClienteOcasionalUseCase;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearClienteOcasionalUseCaseTest {

    private CrearClienteOcasionalUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearClienteOcasionalUseCase();
    }

    @Test
    public void crearClienteOcasionalUseCaseHappyPass(){

        //arrange
        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var clienteId = ClienteId.of("12");
        var clienteOcasionalId = ClienteOcasionalId.of("CF12");
        var nombreCompleto = NombreCompleto.of("Julian");
        var command = new CrearClienteOcasional( clienteId, centroAcondicionamientoId,
                clienteOcasionalId,  nombreCompleto);

        //act
        var eventos = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var clienteOcasionalCreado = (ClienteOcasionalCreado)eventos.get(0);
        Assertions.assertEquals("12", clienteOcasionalCreado.aggregateRootId());
        Assertions.assertEquals("Julian", clienteOcasionalCreado.getNombreCompleto().value());
        Assertions.assertEquals("1", clienteOcasionalCreado.getCentroAcondicionamientoId().value());
    }

}