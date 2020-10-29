package mx.dao;

import java.util.List;
import mx.model.Cuenm01;

public abstract interface CuenM01Dao
{
  public abstract List<Cuenm01> listaFactura();
  
  public abstract List<Cuenm01> lsitaFacturasParciales();
  
  public abstract void insertFactf01(Cuenm01 paramCuenm01);
  
  public abstract void updateFactf01(Cuenm01 paramCuenm01);
  
  public abstract List<Cuenm01> listaReporte();
}


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\dao\CuenM01Dao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */