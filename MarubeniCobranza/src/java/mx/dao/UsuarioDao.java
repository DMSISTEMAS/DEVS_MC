package mx.dao;

import java.util.List;
import mx.model.Usuario;

public abstract interface UsuarioDao
{
  public abstract List<Usuario> listaUsuarios();
  
  public abstract void newUsuario(Usuario paramUsuario);
  
  public abstract void updateUsuario(Usuario paramUsuario);
  
  public abstract void deleteUsuario(Usuario paramUsuario);
}


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\dao\UsuarioDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */