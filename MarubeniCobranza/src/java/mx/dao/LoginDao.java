package mx.dao;

import mx.model.Usuario;

public abstract interface LoginDao {

    public abstract Usuario obternerDatosUsuario(Usuario paramUsuario);

    public abstract Usuario login(Usuario paramUsuario);
}
