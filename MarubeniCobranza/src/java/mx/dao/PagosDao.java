package mx.dao;

import java.util.List;
import mx.model.Pagos;

public abstract interface PagosDao {

    public abstract List<Pagos> listaFactura();

    public abstract void insertFactf01(Pagos paramPagos);

    public abstract void updateFactf01(int paramInt, String paramString);

    public abstract List<Pagos> listarFacturasEnvioCorreos();

    public abstract List<Pagos> listarFacturasSeleccionadas();

    public abstract List<String> listaUsuariosAvisoPago();

    public abstract void updateEnvio(String paramString);

    //Lista para cancelar Pagos
    public List<Pagos> listaCancelarFacturas();
}
