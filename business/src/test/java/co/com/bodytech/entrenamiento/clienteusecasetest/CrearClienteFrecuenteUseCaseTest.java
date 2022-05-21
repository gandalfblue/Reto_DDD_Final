package co.com.bodytech.entrenamiento.clienteusecasetest;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.CentroAcondicionamientoId;
import co.com.bodytech.entrenamiento.cliente.commands.CrearClienteFrecuente;
import co.com.bodytech.entrenamiento.cliente.events.ClienteFrecuenteCreado;
import co.com.bodytech.entrenamiento.cliente.values.ClienteFrecuenteId;
import co.com.bodytech.entrenamiento.cliente.values.ClienteId;
import co.com.bodytech.entrenamiento.clienteusecase.CrearClienteFrecuenteUseCase;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearClienteFrecuenteUseCaseTest {

    private CrearClienteFrecuenteUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearClienteFrecuenteUseCase();
    }

    @Test
    public void crearClienteFrecuenteHappyPass(){

        //arrange
        var centroAcondicionamientoId = CentroAcondicionamientoId.of("1");
        var clienteId = ClienteId.of("12");
        var clienteFrecuenteId = ClienteFrecuenteId.of("CF12");
         var nombreCompleto = NombreCompleto.of("Julian");
        var command = new CrearClienteFrecuente( clienteId, centroAcondicionamientoId,
                                                        clienteFrecuenteId,  nombreCompleto);

        //act
        var eventos = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var clienteFrecuenteCreado = (ClienteFrecuenteCreado)eventos.get(0);
        Assertions.assertEquals("12", clienteFrecuenteCreado.aggregateRootId());
        Assertions.assertEquals("Julian", clienteFrecuenteCreado.getNombreCompleto().value());
        Assertions.assertEquals("1", clienteFrecuenteCreado.getCentroAcondicionamientoId().value());
    }
}