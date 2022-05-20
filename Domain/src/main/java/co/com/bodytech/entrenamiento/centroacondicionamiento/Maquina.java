package co.com.bodytech.entrenamiento.centroacondicionamiento;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.MaquinaId;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.TipoMaquina;
import co.com.sofka.domain.generic.AggregateEvent;

public class Maquina extends AggregateEvent<MaquinaId> {

    protected MaquinaId maquinaId;
    protected TipoMaquina tipoMaquina;

    public Maquina(MaquinaId maquinaId) {
        super(maquinaId);
    }

    public Maquina(MaquinaId maquinaId, TipoMaquina tipoMaquina) {
        super(maquinaId);
        this.tipoMaquina = tipoMaquina;
    }

    public void actualizarMaquina(MaquinaId maquinaId, TipoMaquina tipoMaquina){

        this.maquinaId = MaquinaId.of(maquinaId.value());
        this.tipoMaquina = TipoMaquina.of(tipoMaquina.value());
    }
}
