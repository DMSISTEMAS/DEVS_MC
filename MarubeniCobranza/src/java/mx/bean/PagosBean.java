package mx.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mx.conexion.DAO;
import mx.dao.PagosDao;
import mx.dao.PolPagosDao;
import mx.dao.PolizaPagosDao;
import mx.impl.PagosDaoImpl;
import mx.impl.PolPagosDaoImpl;
import mx.impl.PolizasPagosDaoImpl;
import mx.model.Cuenm01;
import mx.model.Pagos;
import mx.model.Polizapagos;
import mx.model.Usuario;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;

@Named("pagosBean")
@ViewScoped
public class PagosBean extends DAO implements Serializable {

    private Cuenm01 cuen;
    private Pagos pagos;
    private Double importeMxn = 0.0D;
    private Double importeUsd = 0.0D;
    private List<Pagos> listarFolios;
    private String facturas;
    private Polizapagos polPagos;
    private List<Polizapagos> listarPolizasPagos;
    private List<Pagos> listaPagosPol;
    private String periodo;
    private String folioPol;
    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
    private List<Polizapagos> listarRepPol;
    private List<SelectItem> listaFolioPoliza;
    private String folioPoliza;
    private int contarFolios;
    private Double importeTotal = 0.0D;
    private int miFolio;
    private int miMoneda;
    private String miSubCta;
    private String mes;
    private String fechaComprobar;
    private String año;

    public PagosBean() {
        this.cuen = new Cuenm01();
        this.pagos = new Pagos();
        this.polPagos = new Polizapagos();
    }

    public Cuenm01 getCuen() {
        return this.cuen;
    }

    public void setCuen(Cuenm01 cuen) {
        this.cuen = cuen;
    }

    public Pagos getPagos() {
        return this.pagos;
    }

    public void setPagos(Pagos pagos) {
        this.pagos = pagos;
    }

    public Double getImporteMxn() {
        return this.importeMxn;
    }

    public void setImporteMxn(Double importeMxn) {
        this.importeMxn = importeMxn;
    }

    public Double getImporteUsd() {
        return this.importeUsd;
    }

    public void setImporteUsd(Double importeUsd) {
        this.importeUsd = importeUsd;
    }

    public List<Pagos> getListarFolios() {
        return this.listarFolios;
    }

    public String getFacturas() {
        return this.facturas;
    }

    public void setFacturas(String facturas) {
        this.facturas = facturas;
    }

    public Polizapagos getPolPagos() {
        return this.polPagos;
    }

    public void setPolPagos(Polizapagos polPagos) {
        this.polPagos = polPagos;
    }

    public List<Polizapagos> getListarPolizasPagos() {
        return this.listarPolizasPagos;
    }

    public List<Pagos> getListaPagosPol() {
        return this.listaPagosPol;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getFolioPol() {
        return this.folioPol;
    }

    public void setFolioPol(String folioPol) {
        this.folioPol = folioPol;
    }

    public String getFolioPoliza() {
        return this.folioPoliza;
    }

    public void setFolioPoliza(String folioPoliza) {
        this.folioPoliza = folioPoliza;
    }

    public List<Polizapagos> getListarRepPol() {
        return this.listarRepPol;
    }

    public int getContarFolios() {
        return this.contarFolios;
    }

    public void setContarFolios(int contarFolios) {
        this.contarFolios = contarFolios;
    }

    public Double getImporteTotal() {
        return this.importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public void listarTodo() {
        PolPagosDao pDao = new PolPagosDaoImpl();
        this.listarRepPol = pDao.listaRepPol(this.folioPoliza);
        RequestContext.getCurrentInstance().update("frmTest");
    }

    public int getMiFolio() {
        return this.miFolio;
    }

    public void setMiFolio(int miFolio) {
        this.miFolio = miFolio;
    }

    public int getMiMoneda() {
        return this.miMoneda;
    }

    public void setMiMoneda(int miMoneda) {
        this.miMoneda = miMoneda;
    }

    public String getMiSubCta() {
        return this.miSubCta;
    }

    public void setMiSubCta(String miSubCta) {
        this.miSubCta = miSubCta;
    }

    public String getMes() {
        return this.mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getFechaComprobar() {
        return this.fechaComprobar;
    }

    public void setFechaComprobar(String fechaComprobar) {
        this.fechaComprobar = fechaComprobar;
    }

    public String getAño() {
        return this.año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public List<Pagos> buscarPagos() throws SQLException {
        this.importeMxn = 0.0D;
        this.importeUsd = 0.0D;
        if (this.listarFolios != null) {
            this.listarFolios.clear();
        }
        Conectar();
        PreparedStatement ps = getCn().prepareStatement("SELECT DISTINCT SUM(IMPORTE) AS IMPORTE, TCAMBIO, MONEDA, FECHA_PAGO, PAGO_MULTIPLE, BANCO, DEPTO, ESTADO, SUBCUENTA, CTACLIENTESAP, SUM(IMPORTEUSD)AS IMPORTEUSD, CLIENTE FROM pagos WHERE DATEPART(MONTH,FECHA_PAGO)='" + this.mes + "' AND DATEPART(YEAR,FECHA_PAGO)='" + this.año + "' GROUP BY PAGO_MULTIPLE, BANCO,TCAMBIO,MONEDA,FECHA_PAGO,DEPTO,ESTADO,SUBCUENTA,CTACLIENTESAP,CLIENTE");

        ResultSet rs = ps.executeQuery();
        if (!rs.isBeforeFirst()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PAGOS", "No hay pagos pendientes"));
        } else {
            this.listarFolios = null;
            this.listarFolios = new ArrayList();
            while (rs.next()) {
                DecimalFormat df = new DecimalFormat("#.0000");
                this.pagos = new Pagos();
                this.pagos.setPagoMultiple(rs.getInt("PAGO_MULTIPLE"));
                Double impmx = rs.getDouble("IMPORTE");
                this.pagos.setImporte(new Double(df.format(impmx)));
                this.pagos.setTcambio(rs.getDouble("TCAMBIO"));
                this.pagos.setMoneda(rs.getInt("MONEDA"));
                this.pagos.setFechaPago(rs.getDate("FECHA_PAGO"));
                this.fechaComprobar = rs.getString("FECHA_PAGO");
                this.pagos.setBanco(rs.getString("BANCO"));
                this.pagos.setDepto(rs.getString("DEPTO"));
                this.pagos.setEstado(rs.getString("ESTADO"));
                this.pagos.setSubcuenta(rs.getString("SUBCUENTA"));
                this.pagos.setCtaclientesap(rs.getString("CTACLIENTESAP"));
                Double impusd = rs.getDouble("IMPORTEUSD");
                this.pagos.setImporteusd(new Double(df.format(impusd)));
                this.pagos.setCliente(rs.getString("CLIENTE"));
                Conectar();
                PreparedStatement ps2 = getCn().prepareStatement("SELECT FACTURAS FROM fpmultiple WHERE ID='" + this.pagos.getPagoMultiple() + "'");
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    this.facturas = rs2.getString("FACTURAS");
                    this.facturas = this.facturas.replace("[", "");
                    this.facturas = this.facturas.replace("]", "");
                }

                this.pagos.setNoFactura(this.facturas);
                this.listarFolios.add(this.pagos);
            }
        }

        Cerrar();
        return this.listarFolios;
    }

    public void procesarPolizaPagos() throws SQLException {
        PolizaPagosDao pDao = new PolizasPagosDaoImpl();
        guardarFechaTransaccion();
        seleccionarFolio();
        for (int i = 0; i < this.listaPagosPol.size(); i++) {
            if (((Pagos) this.listaPagosPol.get(i)).getProcesado().equals(Boolean.TRUE)) {

                periodoFactura(((Pagos) this.listaPagosPol.get(i)).getNoFactura());
                this.polPagos.setVoucherNo(this.periodo);
                String fecha = ((Pagos) this.listaPagosPol.get(i)).getFechaPago().toString();
                String[] EntryDate = fecha.split("-");
                String year = EntryDate[0];
                String month = EntryDate[1];
                String dia = EntryDate[2];
                dia = dia.substring(0, 2);
                Date fechaHoy = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                this.polPagos.setEntryDate(dateFormat.format(fechaHoy));
                this.polPagos.setTransactionDate(dia + "." + month + "." + year);

                String Currency;
                if (((Pagos) this.listaPagosPol.get(i)).getMoneda().equals(1)) {
                    Currency = "MXN";
                } else {
                    Currency = "USD1";
                }
                this.polPagos.setCurrency(Currency);
                if (((Pagos) this.listaPagosPol.get(i)).getMoneda().equals(2)) {
                    this.polPagos.setRate(((Pagos) this.listaPagosPol.get(i)).getTcambio().toString());
                } else {
                    this.polPagos.setRate("");
                }

                this.polPagos.setRemarks("COBRANZA");
                this.polPagos.setDrcr("CR");
                this.polPagos.setUnit(((Pagos) this.listaPagosPol.get(i)).getDepto());
                this.polPagos.setAccount("11310");
                this.polPagos.setTaxCode("5");
                this.polPagos.setTf("1");
                this.polPagos.setSubAccount(((Pagos) this.listaPagosPol.get(i)).getSubcuenta());
                this.polPagos.setContractNo(((Pagos) this.listaPagosPol.get(i)).getSubctabancos());
                this.polPagos.setReferenceNo(((Pagos) this.listaPagosPol.get(i)).getNoFactura());
                this.polPagos.setDueDate(dia + "." + month + "." + year);

                if (((Pagos) this.listaPagosPol.get(i)).getMoneda().equals(1)) {
                    this.polPagos.setAmount(((Pagos) this.listaPagosPol.get(i)).getImporte().toString());
                } else {
                    this.polPagos.setAmount(((Pagos) this.listaPagosPol.get(i)).getImporteusd().toString());
                }
                this.polPagos.setUserFolio(this.folioPol);
                this.polPagos.setUserName(this.us.getCodigoSap());
                pDao.newPolizas(this.polPagos);
                this.polPagos = new Polizapagos();

                listarFolios(((Pagos) this.listaPagosPol.get(i)).getPagoMultiple());
                String fecha2 = null;
                if (this.contarFolios == 1) {
                    periodoFactura(((Pagos) this.listaPagosPol.get(i)).getNoFactura());
                    this.polPagos.setVoucherNo(this.periodo);
                    this.polPagos.setVoucherNo(this.periodo);
                    fecha2 = ((Pagos) this.listaPagosPol.get(i)).getFechaPago().toString();
                    String[] EntryDate2 = fecha2.split("-");
                    String año2 = EntryDate2[0];
                    String mes2 = EntryDate2[1];
                    String dia2 = EntryDate2[2];
                    dia2 = dia2.substring(0, 2);
                    Date fechaHoy2 = new Date();
                    DateFormat dateFormat2 = new SimpleDateFormat("dd.MM.yyyy");
                    this.polPagos.setEntryDate(dateFormat2.format(fechaHoy2));
                    this.polPagos.setTransactionDate(dia2 + "." + mes2 + "." + año2);

                    String Currency2;
                    if (((Pagos) this.listaPagosPol.get(i)).getMoneda().equals(1)) {
                        Currency2 = "MXN";
                    } else {
                        Currency2 = "USD1";
                    }
                    this.polPagos.setCurrency(Currency2);
                    if (((Pagos) this.listaPagosPol.get(i)).getMoneda().equals(2)) {
                        this.polPagos.setRate(((Pagos) this.listaPagosPol.get(i)).getTcambio().toString());
                    } else {
                        this.polPagos.setRate("");
                    }

                    this.polPagos.setRemarks("COBRANZA");
                    this.polPagos.setDrcr("DR");
                    this.polPagos.setUnit("ZS0M");
                    if (((Pagos) this.listaPagosPol.get(i)).getSubctabancos().contains("1")) {
                        this.polPagos.setAccount("10131");
                    } else {
                        this.polPagos.setAccount("10120");
                    }

                    this.polPagos.setTaxCode("5");
                    this.polPagos.setTf("1");
                    this.polPagos.setSubAccount(((Pagos) this.listaPagosPol.get(i)).getSubctabancos());
                    this.polPagos.setContractNo(((Pagos) this.listaPagosPol.get(i)).getSubcuenta());
                    this.polPagos.setReferenceNo(((Pagos) this.listaPagosPol.get(i)).getSubcuenta());
                    this.polPagos.setDueDate(dia2 + "." + mes2 + "." + año2);

                    if (((Pagos) this.listaPagosPol.get(i)).getMoneda().equals(1)) {
                        this.polPagos.setAmount(((Pagos) this.listaPagosPol.get(i)).getImporte().toString());
                    } else {
                        this.polPagos.setAmount(((Pagos) this.listaPagosPol.get(i)).getImporteusd().toString());
                    }
                    this.polPagos.setUserFolio(this.folioPol);
                    this.polPagos.setUserName(this.us.getCodigoSap());
                    this.polPagos.setProcessed(Boolean.FALSE);
                    pDao.newPolizas(this.polPagos);
                    this.polPagos = new Polizapagos();

                } else if (((Pagos) this.listaPagosPol.get(i)).getMoneda().equals(1)) {

                    importeTotal = importeTotal + ((Pagos) this.listaPagosPol.get(i)).getImporte();
                } else {

                    importeTotal = importeTotal + ((Pagos) this.listaPagosPol.get(i)).getImporteusd();
                }

                actualizarEstado(((Pagos) this.listaPagosPol.get(i)).getNoFactura());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PAGOS", "PÓLIZA GENERADA"));
                RequestContext.getCurrentInstance().update("frmPrincipal:mensaje");
            }
        }

        if (this.contarFolios > 1) {
            Conectar();
            Statement ps = getCn().createStatement();
            ResultSet rs = ps.executeQuery("SELECT TOP(1) TCAMBIO, MONEDA, FECHA_PAGO,  DEPTO, SUBCUENTA, SUBCTABANCOS FROM pagos WHERE PAGO_MULTIPLE=" + this.miFolio + " ");
            while (rs.next()) {
                this.polPagos.setVoucherNo(this.periodo);
                String fecha2 = rs.getString("FECHA_PAGO");
                String[] EntryDate2 = fecha2.split("-");
                String año2 = EntryDate2[0];
                String mes2 = EntryDate2[1];
                String dia2 = EntryDate2[2];
                dia2 = dia2.substring(0, 2);
                Date fechaHoy2 = new Date();
                DateFormat dateFormat2 = new SimpleDateFormat("dd.MM.yyyy");
                this.polPagos.setEntryDate(dateFormat2.format(fechaHoy2));
                this.polPagos.setTransactionDate(dia2 + "." + mes2 + "." + año2);

                this.miMoneda = rs.getInt("MONEDA");
                String Currency2;
                if (this.miMoneda == 1) {
                    Currency2 = "MXN";
                } else {
                    Currency2 = "USD1";
                }
                this.polPagos.setCurrency(Currency2);
                if (this.miMoneda == 2) {
                    this.polPagos.setRate(rs.getString("TCAMBIO"));
                } else {
                    this.polPagos.setRate("");
                }

                this.polPagos.setRemarks("COBRANZA");
                this.polPagos.setDrcr("DR");
                this.polPagos.setUnit("ZS0M");
                this.miSubCta = rs.getString("SUBCTABANCOS");
                if (this.miSubCta.contains("1")) {
                    this.polPagos.setAccount("10131");
                } else {
                    this.polPagos.setAccount("10120");
                }

                this.polPagos.setTaxCode("5");
                this.polPagos.setTf("1");
                this.polPagos.setSubAccount(rs.getString("SUBCTABANCOS"));
                this.polPagos.setContractNo(rs.getString("SUBCUENTA"));
                this.polPagos.setReferenceNo(rs.getString("SUBCUENTA"));
                this.polPagos.setDueDate(dia2 + "." + mes2 + "." + año2);

                this.polPagos.setAmount(this.importeTotal.toString());

                this.polPagos.setUserFolio(this.folioPol);
                this.polPagos.setUserName(this.us.getCodigoSap());
                this.polPagos.setProcessed(Boolean.FALSE);
                pDao.newPolizas(this.polPagos);
                this.polPagos = new Polizapagos();
            }

            System.out.println(this.importeTotal);
            Cerrar();
        }
        Cerrar();
        listar();
        RequestContext.getCurrentInstance().update("frm:tblPagos");
    }

    public void periodoFactura(String factura) throws SQLException {
        Conectar();
        PreparedStatement ps = getCn().prepareStatement("SELECT FECHA_APLI FROM cuenm01 WHERE NO_FACTURA='" + factura + "'");
        ResultSet rs = ps.executeQuery();
        if (rs.isBeforeFirst()) {

            while (rs.next()) {
                String Fecha_Apli = rs.getString("FECHA_APLI");
                String[] fecha = Fecha_Apli.split("-");
                String month = fecha[1];
                this.periodo = month;
            }
        }
    }

    public void guardarFechaTransaccion() throws SQLException {
        Conectar();

        Statement st = getCn().createStatement();
        st.executeUpdate("INSERT INTO foliopoliza VALUES(GETDATE(),'" + this.us.getNombre() + "')");
        Cerrar();
    }

    public void seleccionarFolio() throws SQLException {
        Conectar();
        PreparedStatement ps = getCn().prepareStatement("SELECT TOP(1) IDPOL FROM foliopoliza ORDER BY IDPOL DESC");
        ResultSet rs = ps.executeQuery();
        if (rs.isBeforeFirst()) {

            while (rs.next()) {
                this.folioPol = rs.getString("IDPOL");
            }
        }
        Cerrar();
    }

    public void actualizarEstado(String factura) throws SQLException {
        Conectar();
        PreparedStatement ps = getCn().prepareStatement("UPDATE pagos SET PROCESADO=1 WHERE NO_FACTURA='" + factura + "'");
        ps.executeUpdate();
        Cerrar();
    }

    public List<SelectItem> getListaFolioPoliza() {
        this.listaFolioPoliza = new ArrayList();
        PolizaPagosDao lDao = new PolizasPagosDaoImpl();
        List<String> l = lDao.listarFoliosPoliza();
        for (String item : l) {
            SelectItem nombreItem = new SelectItem(item);
            this.listaFolioPoliza.add(nombreItem);
        }
        return this.listaFolioPoliza;
    }

    public void listar() {
        PagosDao pDao = new PagosDaoImpl();
        this.listaPagosPol = pDao.listaFactura();
    }

    public void listarFolios(int folio) throws SQLException {
        this.miFolio = folio;
        Conectar();
        this.contarFolios = 0;
        Statement ps = getCn().createStatement();
        ResultSet rs = ps.executeQuery("SELECT COUNT (PAGO_MULTIPLE) AS PAGO_MULTIPLE FROM pagos WHERE PAGO_MULTIPLE=" + folio + "");
        while (rs.next()) {
            this.contarFolios = rs.getInt("PAGO_MULTIPLE");
        }
        Cerrar();
    }

    public void actualizarEstadoPoliza() throws SQLException, InterruptedException {
        Conectar();
        PreparedStatement ps = getCn().prepareStatement("UPDATE polizapagos SET processed=1 WHERE userFolio='" + this.folioPoliza + "'");
        ps.executeUpdate();
        listarTodo();
        getListaFolioPoliza();
        RequestContext.getCurrentInstance().update("frmPrincipal:reportePoliza");
        Cerrar();
    }

    public void resetearTabla() {
        DataTable datatable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("frmPrincipal:ReportePagos");
        datatable.reset();
    }

    public void descargarReporte()
            throws SQLException, InterruptedException {
        actualizarEstadoPoliza();
        RequestContext.getCurrentInstance().execute("window.location.reload()");
    }

    public void refrescarPagina() {
        RequestContext.getCurrentInstance().execute("window.location.reload()");
    }
}
