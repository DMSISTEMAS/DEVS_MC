package mx.dao;

import java.util.List;

public abstract interface CorreosDao {

    public abstract List<String> listaCorreos(String paramString);
}
