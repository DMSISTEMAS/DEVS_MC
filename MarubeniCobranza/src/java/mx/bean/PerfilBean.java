package mx.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mx.dao.PerfilDao;
import mx.impl.PerfilDaoImpl;
import mx.model.Usuario;

@Named("PerfilBean")
@ViewScoped
public class PerfilBean
        implements Serializable {

    private List<Usuario> listaUsuario;
    private Usuario usuario;
    private List<Usuario> listaPoliza;

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        PerfilDao cDao = new PerfilDaoImpl();
        this.listaUsuario = cDao.listaUsuarios();
        return this.listaUsuario;
    }

    public List<Usuario> getListaPoliza() {
        PerfilDao cDao = new PerfilDaoImpl();
        this.listaPoliza = cDao.admonPoliza();
        return this.listaPoliza;
    }

    public void setListaPoliza(List<Usuario> listaPoliza) {
        this.listaPoliza = listaPoliza;
    }
}
