package mx.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mx.dao.UsuarioDao;
import mx.impl.UsuarioDaoImpl;
import mx.model.Usuario;

@Named("usuarioBean")
@ViewScoped
public class usuarioBean
        implements Serializable {

    private List<Usuario> listaUsuario;
    private Usuario usuario;

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        UsuarioDao uDao = new UsuarioDaoImpl();
        this.listaUsuario = uDao.listaUsuarios();
        return this.listaUsuario;
    }

    public void prepararNuevoUsuario() {
        this.usuario = new Usuario();
    }

    public void nuevoUsuario() {
        UsuarioDao uDao = new UsuarioDaoImpl();
        uDao.newUsuario(this.usuario);
    }

    public void modificarUsuario() {
        UsuarioDao uDao = new UsuarioDaoImpl();
        uDao.updateUsuario(this.usuario);
        this.usuario = new Usuario();
    }

    public void eliminarUsuario() {
        UsuarioDao uDao = new UsuarioDaoImpl();
        uDao.deleteUsuario(this.usuario);
        this.usuario = new Usuario();
    }
}
