package mx.dao;

import java.util.List;
import mx.model.Polizapagos;

public abstract interface PolizaPagosDao {

    public abstract List<Polizapagos> listaPolizas();

    public abstract void newPolizas(Polizapagos paramPolizapagos);

    public abstract void updatePolizas(Polizapagos paramPolizapagos);

    public abstract void deletePolizas(Polizapagos paramPolizapagos);

    public abstract List<String> listarFoliosPoliza();

    public abstract List<Polizapagos> listaFoliosPendientes();
}
