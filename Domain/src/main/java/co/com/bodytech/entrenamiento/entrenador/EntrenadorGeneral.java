package co.com.bodytech.entrenamiento.entrenador;

import co.com.bodytech.entrenamiento.genericos.Email;
import co.com.bodytech.entrenamiento.entrenador.values.EntrenadorGeneralId;
import co.com.bodytech.entrenamiento.entrenador.values.TipoDeEntrenador;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;

public class EntrenadorGeneral extends AggregateEvent<EntrenadorGeneralId> {

    protected Telefono telefono;
    protected Email email;
    protected EntrenadorGeneralId entrenadorGeneralId;
    protected TipoDeEntrenador tipoDeEntrenador;
    protected NombreCompleto nombreCompleto;

    public EntrenadorGeneral(EntrenadorGeneralId entrenadorGeneralId) {
        super(entrenadorGeneralId);
    }

    public EntrenadorGeneral(EntrenadorGeneralId entrenadorGeneralId, Telefono telefono,
                             Email email, NombreCompleto nombreCompleto) {

        super(entrenadorGeneralId);
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public EntrenadorGeneral(EntrenadorGeneralId entrenadorGeneralId,
                             TipoDeEntrenador tipoDeEntrenador, NombreCompleto nombreCompleto) {
        super(entrenadorGeneralId);
        this.tipoDeEntrenador = tipoDeEntrenador;
        this.nombreCompleto = nombreCompleto;
    }

    public void actualizarEntrenadorGeneral(EntrenadorGeneralId entrenadorGeneralId, Telefono telefono,
                                            Email email, NombreCompleto nombreCompleto){

        this.entrenadorGeneralId = EntrenadorGeneralId.of(entrenadorGeneralId.value());
        this.email = Email.of(email.value());
        this.nombreCompleto = NombreCompleto.of(nombreCompleto.value());
        this.telefono = Telefono.of(telefono.value());
    }
}
