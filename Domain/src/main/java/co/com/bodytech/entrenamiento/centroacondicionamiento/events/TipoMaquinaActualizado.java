package co.com.bodytech.entrenamiento.centroacondicionamiento.events;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.MaquinaId;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoMaquinaActualizado extends DomainEvent {

    private final MaquinaId maquinaId;
    public TipoMaquinaActualizado(MaquinaId maquinaId) {
        super("co.com.bodytech.entrenamiento.centroacondicionamiento.events.TipoMaquinaActualizado");
        this.maquinaId = maquinaId;
    }

    public MaquinaId getMaquinaId() {
        return maquinaId;
    }
}
