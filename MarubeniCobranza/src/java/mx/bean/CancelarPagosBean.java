package mx.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import mx.conexion.DAO;
import mx.dao.PagosDao;
import mx.impl.PagosDaoImpl;
import mx.model.Pagos;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;

@Named(value = "cancelarPagosBean")
@ViewScoped
public class CancelarPagosBean extends DAO implements Serializable {

    private List<Pagos> lista;
    private Pagos pagos;

    public CancelarPagosBean() {
        this.lista = new ArrayList<>();
        this.pagos = new Pagos();
    }

    public Pagos getPagos() {
        return pagos;
    }

    public void setPagos(Pagos pagos) {
        this.pagos = pagos;
    }

    public void setLista(List<Pagos> lista) {
        this.lista = lista;
    }

    public List<Pagos> getLista() {
        PagosDao pDao = new PagosDaoImpl();
        this.lista = pDao.listaCancelarFacturas();
        return lista;
    }

    public void cancelar() {
        String sql = "";
        for (int i = 0; i < lista.size(); i++) {
            try {
                if (lista.get(i).getBandera().equals(true)) {

                    //REGRESAR LOS SALDOS PAGADOS A LA TABLA cuenm01 DE LA BD COBRANZA
                    this.Conectar();

                    PreparedStatement psCuen = getCn().prepareStatement("SELECT NUM_MONED FROM cuenm01 WHERE NO_FACTURA='" + lista.get(i).getNoFactura() + "'");
                    ResultSet rsCuen = psCuen.executeQuery();
                    int coin = 0;

                    while (rsCuen.next()) {
                        coin = rsCuen.getInt("NUM_MONED");
                    }
                    String sqlcuen = null;
                    if (coin == 2) {
                        sqlcuen = "UPDATE cuenm01 "
                                + "SET SALDO=SALDO + " + lista.get(i).getImporteusd() + ", "
                                + "PAGO_MULTIPLE=NULL, PROCESADO=0, BANCO=NULL, DEPTO=NULL, AVISO=NULL, FECHA_ENVIO=NULL, FECHA_PAGO=NULL"
                                + " WHERE NO_FACTURA='" + lista.get(i).getNoFactura() + "'";
                    } else {
                        sqlcuen = "UPDATE cuenm01 "
                                + "SET SALDO=SALDO + " + lista.get(i).getImporte() + ", "
                                + "PAGO_MULTIPLE=NULL, PROCESADO=0, BANCO=NULL, DEPTO=NULL, AVISO=NULL, FECHA_ENVIO=NULL, FECHA_PAGO=NULL"
                                + " WHERE NO_FACTURA='" + lista.get(i).getNoFactura() + "'";
                    }

                    PreparedStatement pSaldos = getCn().prepareStatement(sqlcuen);
                    pSaldos.executeUpdate();
                    sqlcuen = null;
                    this.Cerrar();

                    //BORRAR EN LA TABLA pagos DE LA BD COBRANZA
                    this.Conectar();
                    PreparedStatement psPagos = getCn().prepareStatement("DELETE FROM pagos WHERE ID='" + lista.get(i).getId() + "'");
                    psPagos.executeUpdate();
                    this.Cerrar();

                    //BORRAR Y/O ACTUALIZAR LA TABLA fpmultiple
                    this.Conectar();

//                    PreparedStatement psFac = getCn().prepareStatement("SELECT FACTURAS FROM fpmultiple WHERE ID='" + lista.get(i).getPagoMultiple() + "'");
//                    ResultSet rsFac = psFac.executeQuery();
//                    String facturas = "";
//                    if (rsFac.isBeforeFirst()) {
//                        
//                    } else {
//                        while (rsFac.next()) {
//                            facturas = rsFac.getString("FACTURAS");
//                        }
//                    }
//                    // FACTURAS = REPLACE(phone,'(916)','(917)')
//                    facturas = facturas.replace(", " + lista.get(i).getNoFactura(), "");
                    PreparedStatement psfp = getCn().prepareStatement("UPDATE fpmultiple SET FACTURAS=REPLACE(FACTURAS,'" + lista.get(i).getNoFactura() + "', '') WHERE ID='" + lista.get(i).getPagoMultiple() + "' ");
                    psfp.executeUpdate();
                    this.Cerrar();
                    //facturas = "";

                    //VALIDAR SI ES PAGO MÚLTIPLE
                    int contador = 0;

//                    this.Conectar();
//                    PreparedStatement preparedStatement = getCn().prepareStatement("SELECT COUNT(PAGO_MULTIPLE) AS CUENTA FROM pagos WHERE PAGO_MULTIPLE='" + lista.get(i).getPagoMultiple() + "'");
//                    ResultSet resultSet = preparedStatement.executeQuery();
//                    while (resultSet.next()) {
//                        contador = resultSet.getInt("CUENTA");
//                    }
//                    this.Cerrar();
//                    if (contador > 1) {
//                        sql = "DELETE FROM CUEN_DET01 "
//                                + "WHERE REFER  IN (SELECT TOP(1) "
//                                + "cd.REFER  "
//                                + "FROM CUEN_DET01 cd "
//                                + "WHERE  cd.REFER='" + lista.get(i).getNoFactura() + "' "
//                                + "AND cd.NO_FACTURA='" + lista.get(i).getNoFactura() + "' "
//                                + "AND cd.DOCTO='PM" + lista.get(i).getPagoMultiple() + "' "
//                                + "ORDER BY cd.FECHA_APLI DESC);";
//                    } else {
//                        
//                        this.ConectarSAE();
//                        PreparedStatement statement = getCnSAE().prepareStatement("SELECT * FROM CUEN_DET01 WHERE DOCTO='PM" + lista.get(i).getPagoMultiple() + "'");
//                        ResultSet set = statement.executeQuery();
//                        if (set.isBeforeFirst()) {
//                            sql = "DELETE FROM CUEN_DET01 "
//                                    + "WHERE REFER  IN (SELECT TOP(1) "
//                                    + "cd.REFER  "
//                                    + "FROM CUEN_DET01 cd "
//                                    + "WHERE  cd.REFER='" + lista.get(i).getNoFactura() + "' "
//                                    + "AND cd.NO_FACTURA='" + lista.get(i).getNoFactura() + "' "
//                                    + "AND cd.PARTIDA='" + lista.get(i).getPartida() + "' "
//                                    + "ORDER BY cd.FECHA_APLI DESC);";
//                        } else {
////                            sql = "DELETE FROM CUEN_DET01 "
////                                    + "WHERE REFER  IN (SELECT TOP(1) "
////                                    + "cd.REFER  "
////                                    + "FROM CUEN_DET01 cd "
////                                    + "WHERE  cd.REFER='" + lista.get(i).getNoFactura() + "' "
////                                    + "AND CVE_CLIE='" + lista.get(i).getCvecliente() + "' "
////                                    + "ORDER BY cd.FECHA_APLI DESC);";
//                        }
//                        this.CerrarSAE();
//                        
//                    }
                    //BORRAR REGISTROS EN SAE-TABLA CUENDET01
                    this.ConectarSAE();
                    String sql1 = "DELETE FROM CUEN_DET01 "
                            + "WHERE REFER='" + lista.get(i).getNoFactura() + "' AND NO_PARTIDA='" + lista.get(i).getPartida() + "' "
                            + "AND IMPORTE='" + lista.get(i).getImporte() + "' AND FECHA_APLI='" + lista.get(i).getFechaPago() + "'";
                    // PreparedStatement ps = getCnSAE().prepareStatement(sql);
                    PreparedStatement ps = getCnSAE().prepareStatement(sql1);
                    ps.executeUpdate();
                    this.CerrarSAE();
                    sql = "";

                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        //RequestContext.getCurrentInstance().execute("swal({ title: 'Proceso terminado',text: '', icon: 'success', button: 'OK',});");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE COBRANZA", "CORRECCIÓN DE PAGO APLICADA"));
        RequestContext.getCurrentInstance().update("frmPrincipal:tblPagos");

    }

    public void resetearTabla() {
        DataTable datatable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("frmPrincipal:tblPagos");
        datatable.reset();
    }

}
