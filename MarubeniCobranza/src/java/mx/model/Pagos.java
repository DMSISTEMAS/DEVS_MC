package mx.model;

import java.util.Date;

public class Pagos implements java.io.Serializable {

    private int id;
    private String noFactura;
    private Double importe;
    private Double tcambio;
    private Integer moneda;
    private Date fechaPago;
    private Integer pagoMultiple;
    private Boolean procesado;
    private String banco;
    private String depto;
    private String estado;
    private String subcuenta;
    private String ctaclientesap;
    private Double importeusd;
    private String cliente;
    private String subctabancos;
    private String enviado;
    private String strcvevend;
    private Integer tipopago;
    private String cvecliente;

    public Pagos() {
    }

    public Pagos(int id) {
        this.id = id;
    }

    public Pagos(int id, String noFactura, Double importe, Double tcambio, Integer moneda, Date fechaPago, Integer pagoMultiple, Boolean procesado, String banco, String depto, String estado, String subcuenta, String ctaclientesap, Double importeusd, String cliente, String subctabancos, String enviado, String strcvevend, Integer tipopago, String cvecliente) {
        this.id = id;
        this.noFactura = noFactura;
        this.importe = importe;
        this.tcambio = tcambio;
        this.moneda = moneda;
        this.fechaPago = fechaPago;
        this.pagoMultiple = pagoMultiple;
        this.procesado = procesado;
        this.banco = banco;
        this.depto = depto;
        this.estado = estado;
        this.subcuenta = subcuenta;
        this.ctaclientesap = ctaclientesap;
        this.importeusd = importeusd;
        this.cliente = cliente;
        this.subctabancos = subctabancos;
        this.enviado = enviado;
        this.strcvevend = strcvevend;
        this.tipopago = tipopago;
        this.cvecliente = cvecliente;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoFactura() {
        return this.noFactura;
    }

    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    public Double getImporte() {
        return this.importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getTcambio() {
        return this.tcambio;
    }

    public void setTcambio(Double tcambio) {
        this.tcambio = tcambio;
    }

    public Integer getMoneda() {
        return this.moneda;
    }

    public void setMoneda(Integer moneda) {
        this.moneda = moneda;
    }

    public Date getFechaPago() {
        return this.fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Integer getPagoMultiple() {
        return this.pagoMultiple;
    }

    public void setPagoMultiple(Integer pagoMultiple) {
        this.pagoMultiple = pagoMultiple;
    }

    public Boolean getProcesado() {
        return this.procesado;
    }

    public void setProcesado(Boolean procesado) {
        this.procesado = procesado;
    }

    public String getBanco() {
        return this.banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getDepto() {
        return this.depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSubcuenta() {
        return this.subcuenta;
    }

    public void setSubcuenta(String subcuenta) {
        this.subcuenta = subcuenta;
    }

    public String getCtaclientesap() {
        return this.ctaclientesap;
    }

    public void setCtaclientesap(String ctaclientesap) {
        this.ctaclientesap = ctaclientesap;
    }

    public Double getImporteusd() {
        return this.importeusd;
    }

    public void setImporteusd(Double importeusd) {
        this.importeusd = importeusd;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getSubctabancos() {
        return this.subctabancos;
    }

    public void setSubctabancos(String subctabancos) {
        this.subctabancos = subctabancos;
    }

    public String getEnviado() {
        return this.enviado;
    }

    public void setEnviado(String enviado) {
        this.enviado = enviado;
    }

    public String getStrcvevend() {
        return this.strcvevend;
    }

    public void setStrcvevend(String strcvevend) {
        this.strcvevend = strcvevend;
    }

    public Integer getTipopago() {
        return this.tipopago;
    }

    public void setTipopago(Integer tipopago) {
        this.tipopago = tipopago;
    }

    public String getCvecliente() {
        return this.cvecliente;
    }

    public void setCvecliente(String cvecliente) {
        this.cvecliente = cvecliente;
    }
}
