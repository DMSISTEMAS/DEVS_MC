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
    private Boolean bandera;
    private String partida;

    public Pagos() {
    }

    public Pagos(int id, String noFactura, Double importe, Double tcambio, Integer moneda, Date fechaPago, Integer pagoMultiple, Boolean procesado, String banco, String depto, String estado, String subcuenta, String ctaclientesap, Double importeusd, String cliente, String subctabancos, String enviado, String strcvevend, Integer tipopago, String cvecliente, Boolean bandera, String partida) {
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
        this.bandera = bandera;
        this.partida = partida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getTcambio() {
        return tcambio;
    }

    public void setTcambio(Double tcambio) {
        this.tcambio = tcambio;
    }

    public Integer getMoneda() {
        return moneda;
    }

    public void setMoneda(Integer moneda) {
        this.moneda = moneda;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Integer getPagoMultiple() {
        return pagoMultiple;
    }

    public void setPagoMultiple(Integer pagoMultiple) {
        this.pagoMultiple = pagoMultiple;
    }

    public Boolean getProcesado() {
        return procesado;
    }

    public void setProcesado(Boolean procesado) {
        this.procesado = procesado;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSubcuenta() {
        return subcuenta;
    }

    public void setSubcuenta(String subcuenta) {
        this.subcuenta = subcuenta;
    }

    public String getCtaclientesap() {
        return ctaclientesap;
    }

    public void setCtaclientesap(String ctaclientesap) {
        this.ctaclientesap = ctaclientesap;
    }

    public Double getImporteusd() {
        return importeusd;
    }

    public void setImporteusd(Double importeusd) {
        this.importeusd = importeusd;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getSubctabancos() {
        return subctabancos;
    }

    public void setSubctabancos(String subctabancos) {
        this.subctabancos = subctabancos;
    }

    public String getEnviado() {
        return enviado;
    }

    public void setEnviado(String enviado) {
        this.enviado = enviado;
    }

    public String getStrcvevend() {
        return strcvevend;
    }

    public void setStrcvevend(String strcvevend) {
        this.strcvevend = strcvevend;
    }

    public Integer getTipopago() {
        return tipopago;
    }

    public void setTipopago(Integer tipopago) {
        this.tipopago = tipopago;
    }

    public String getCvecliente() {
        return cvecliente;
    }

    public void setCvecliente(String cvecliente) {
        this.cvecliente = cvecliente;
    }

    public Boolean getBandera() {
        return bandera;
    }

    public void setBandera(Boolean bandera) {
        this.bandera = bandera;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

}
