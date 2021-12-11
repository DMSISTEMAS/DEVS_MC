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


