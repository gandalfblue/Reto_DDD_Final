package co.com.bodytech.entrenamiento.clienteusecasetest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.commands.CrearClienteVIP;
import co.com.bodytech.entrenamiento.cliente.events.ClienteVIPCreado;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteVIPId;
import co.com.bodytech.entrenamiento.clienteusecase.CrearClienteVIPUseCase;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearClienteVIPUseCaseTest {


    private CrearClienteVIPUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearClienteVIPUseCase();
    }

    @Test
    public void crearClienteVIPHappyPass(){

        //arrange
        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var clienteId = ClienteId.of("12");
        var clienteVIPId = ClienteVIPId.of("CF12");
        var nombreCompleto = NombreCompleto.of("Julian");
        var command = new CrearClienteVIP( centroAcondicionamientoId, clienteId,
                nombreCompleto, clienteVIPId);

        //act
        var eventos = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var clienteVIPCreado = (ClienteVIPCreado)eventos.get(0);
        Assertions.assertEquals("12", clienteVIPCreado.aggregateRootId());
        Assertions.assertEquals("Julian", clienteVIPCreado.getNombreCompleto().value());
        Assertions.assertEquals("1", clienteVIPCreado.getCentroAcondicionamientoId().value());
    }
}