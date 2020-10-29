package mx.model;

import java.util.Date;

public class Cuenm01 implements java.io.Serializable {

    private String noFactura;
    private String cveClie;
    private String rfc;
    private String nombreClie;
    private Double importe;
    private Date fechaApli;
    private Integer numMoned;
    private Double tcambio;
    private Double impmonExt;
    private String strcvevend;
    private String nombreVend;
    private Boolean pagoParcial;
    private Double nuevoImporte;
    private Double nuevoTcambio;
    private Integer nuevoMoneda;
    private String tipoPago;
    private Integer aviso;
    private Boolean procesado;
    private Date fechaIngreso;
    private Date fechaEnvio;
    private Boolean completado;
    private String banco;
    private Date fechaPago;
    private Integer pagoMultiple;
    private String depto;
    private Double saldo;
    private Boolean proParcial;

    public Cuenm01() {
    }

    public Cuenm01(String noFactura) {
        this.noFactura = noFactura;
    }

    public Cuenm01(String noFactura, String cveClie, String rfc, String nombreClie, Double importe, Date fechaApli, Integer numMoned, Double tcambio, Double impmonExt, String strcvevend, String nombreVend, Boolean pagoParcial, Double nuevoImporte, Double nuevoTcambio, Integer nuevoMoneda, String tipoPago, Integer aviso, Boolean procesado, Date fechaIngreso, Date fechaEnvio, Boolean completado, String banco, Date fechaPago, Integer pagoMultiple, String depto, Double saldo, Boolean proParcial) {
        this.noFactura = noFactura;
        this.cveClie = cveClie;
        this.rfc = rfc;
        this.nombreClie = nombreClie;
        this.importe = importe;
        this.fechaApli = fechaApli;
        this.numMoned = numMoned;
        this.tcambio = tcambio;
        this.impmonExt = impmonExt;
        this.strcvevend = strcvevend;
        this.nombreVend = nombreVend;
        this.pagoParcial = pagoParcial;
        this.nuevoImporte = nuevoImporte;
        this.nuevoTcambio = nuevoTcambio;
        this.nuevoMoneda = nuevoMoneda;
        this.tipoPago = tipoPago;
        this.aviso = aviso;
        this.procesado = procesado;
        this.fechaIngreso = fechaIngreso;
        this.fechaEnvio = fechaEnvio;
        this.completado = completado;
        this.banco = banco;
        this.fechaPago = fechaPago;
        this.pagoMultiple = pagoMultiple;
        this.depto = depto;
        this.saldo = saldo;
        this.proParcial = proParcial;
    }

    public String getNoFactura() {
        return this.noFactura;
    }

    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    public String getCveClie() {
        return this.cveClie;
    }

    public void setCveClie(String cveClie) {
        this.cveClie = cveClie;
    }

    public String getRfc() {
        return this.rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombreClie() {
        return this.nombreClie;
    }

    public void setNombreClie(String nombreClie) {
        this.nombreClie = nombreClie;
    }

    public Double getImporte() {
        return this.importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Date getFechaApli() {
        return this.fechaApli;
    }

    public void setFechaApli(Date fechaApli) {
        this.fechaApli = fechaApli;
    }

    public Integer getNumMoned() {
        return this.numMoned;
    }

    public void setNumMoned(Integer numMoned) {
        this.numMoned = numMoned;
    }

    public Double getTcambio() {
        return this.tcambio;
    }

    public void setTcambio(Double tcambio) {
        this.tcambio = tcambio;
    }

    public Double getImpmonExt() {
        return this.impmonExt;
    }

    public void setImpmonExt(Double impmonExt) {
        this.impmonExt = impmonExt;
    }

    public String getStrcvevend() {
        return this.strcvevend;
    }

    public void setStrcvevend(String strcvevend) {
        this.strcvevend = strcvevend;
    }

    public String getNombreVend() {
        return this.nombreVend;
    }

    public void setNombreVend(String nombreVend) {
        this.nombreVend = nombreVend;
    }

    public Boolean getPagoParcial() {
        return this.pagoParcial;
    }

    public void setPagoParcial(Boolean pagoParcial) {
        this.pagoParcial = pagoParcial;
    }

    public Double getNuevoImporte() {
        return this.nuevoImporte;
    }

    public void setNuevoImporte(Double nuevoImporte) {
        this.nuevoImporte = nuevoImporte;
    }

    public Double getNuevoTcambio() {
        return this.nuevoTcambio;
    }

    public void setNuevoTcambio(Double nuevoTcambio) {
        this.nuevoTcambio = nuevoTcambio;
    }

    public Integer getNuevoMoneda() {
        return this.nuevoMoneda;
    }

    public void setNuevoMoneda(Integer nuevoMoneda) {
        this.nuevoMoneda = nuevoMoneda;
    }

    public String getTipoPago() {
        return this.tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Integer getAviso() {
        return this.aviso;
    }

    public void setAviso(Integer aviso) {
        this.aviso = aviso;
    }

    public Boolean getProcesado() {
        return this.procesado;
    }

    public void setProcesado(Boolean procesado) {
        this.procesado = procesado;
    }

    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEnvio() {
        return this.fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Boolean getCompletado() {
        return this.completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    public String getBanco() {
        return this.banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
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

    public String getDepto() {
        return this.depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Boolean getProParcial() {
        return this.proParcial;
    }

    public void setProParcial(Boolean proParcial) {
        this.proParcial = proParcial;
    }
}
