package mx.dao;

import java.util.List;
import mx.model.Polizapagos;

public abstract interface PolPagosDao {

    public abstract List<Polizapagos> listaRepPol(String paramString);
}
