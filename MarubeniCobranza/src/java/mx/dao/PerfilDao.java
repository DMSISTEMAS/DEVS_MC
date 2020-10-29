package mx.dao;

import java.util.List;
import mx.model.Usuario;

public abstract interface PerfilDao {

    public abstract List<Usuario> listaUsuarios();

    public abstract List<Usuario> admonPoliza();
}
