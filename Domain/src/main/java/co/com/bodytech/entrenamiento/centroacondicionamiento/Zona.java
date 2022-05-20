package co.com.bodytech.entrenamiento.centroacondicionamiento;

import co.com.bodytech.entrenamiento.centroacondicionamiento.values.TipoDeZona;
import co.com.bodytech.entrenamiento.centroacondicionamiento.values.ZonaId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Zona extends AggregateEvent<ZonaId> {

    protected TipoDeZona tipoDeZona;
    protected ZonaId zonaId;


    public Zona(ZonaId zonaId) {
        super(zonaId);
    }

    public Zona(ZonaId zonaId, TipoDeZona tipoDeZona) {
        super(zonaId);
        this.tipoDeZona = tipoDeZona;
    }

    public void actualizarZona(ZonaId zonaId, TipoDeZona tipoDeZona){

        this.zonaId = ZonaId.of(zonaId.value());
        this.tipoDeZona = TipoDeZona.of(tipoDeZona.value());
    }
}
