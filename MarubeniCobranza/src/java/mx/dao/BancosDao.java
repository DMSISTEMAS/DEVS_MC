package mx.dao;

import java.util.List;
import mx.model.Bancos;

public abstract interface BancosDao {

    public abstract List<Bancos> listaBancos();
}
