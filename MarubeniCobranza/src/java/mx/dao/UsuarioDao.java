package mx.dao;

import java.util.List;
import mx.model.Usuario;

public abstract interface UsuarioDao {

    public abstract List<Usuario> listaUsuarios();

    public abstract void newUsuario(Usuario paramUsuario);

    public abstract void updateUsuario(Usuario paramUsuario);

    public abstract void deleteUsuario(Usuario paramUsuario);
}
