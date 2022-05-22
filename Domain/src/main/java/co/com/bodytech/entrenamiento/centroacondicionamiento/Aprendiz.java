package co.com.bodytech.entrenamiento.centroacondicionamiento;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.AprendizId;
import co.com.bodytech.entrenamiento.genericos.Email;
import co.com.bodytech.entrenamiento.genericos.NombreCompleto;
import co.com.bodytech.entrenamiento.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;

public class Aprendiz extends AggregateEvent<AprendizId> {

    protected AprendizId aprendizId;
    protected Telefono telefono;
    protected Email email;
    protected NombreCompleto nombreCompleto;


    public Aprendiz(AprendizId aprendizId) {
        super(aprendizId);
    }

    public Aprendiz(AprendizId aprendizId, Telefono telefono, Email email, NombreCompleto nombreCompleto) {
        super(aprendizId);
        this.telefono = telefono;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public Aprendiz(AprendizId aprendizId, Telefono telefono,
                                                        NombreCompleto nombreCompleto) {
        super(aprendizId);
        this.aprendizId = aprendizId;
        this.telefono = telefono;
        this.nombreCompleto = nombreCompleto;
    }

    public void actualizarAprendiz(AprendizId aprendizId, Telefono telefono, Email email, NombreCompleto nombreCompleto){

        this.aprendizId = AprendizId.of(aprendizId.value());
        this.email = Email.of(email.value());
        this.nombreCompleto = NombreCompleto.of(nombreCompleto.value());
        this.telefono = Telefono.of(telefono.value());
    }
}
