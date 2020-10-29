package mx.dao;

import java.util.List;
import mx.model.Pagos;

public abstract interface PagosDao
{
  public abstract List<Pagos> listaFactura();
  
  public abstract void insertFactf01(Pagos paramPagos);
  
  public abstract void updateFactf01(int paramInt, String paramString);
  
  public abstract List<Pagos> listarFacturasEnvioCorreos();
  
  public abstract List<Pagos> listarFacturasSeleccionadas();
  
  public abstract List<String> listaUsuariosAvisoPago();
  
  public abstract void updateEnvio(String paramString);
}


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\dao\PagosDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */