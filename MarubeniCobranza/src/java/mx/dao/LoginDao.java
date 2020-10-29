package mx.dao;

import mx.model.Usuario;

public abstract interface LoginDao
{
  public abstract Usuario obternerDatosUsuario(Usuario paramUsuario);
  
  public abstract Usuario login(Usuario paramUsuario);
}


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\dao\LoginDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */