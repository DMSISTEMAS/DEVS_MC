package mx.model;

import java.util.Date;

public class Usuario implements java.io.Serializable {

    private String nombre;
    private String correo;
    private String codigoPerfil;
    private String codigoDepartamento;
    private String codigoSap;
    private String folioUsuario;
    private String clave;
    private String asignacion;
    private String asignacionusd;
    private Date fechaAlta;
    private Integer vigencia;
    private String tarjetaCoorporativa;
    private String estatus;
    private String tarjetaGasolina;
    private String admonPoliza;
    private Date fechaAcceso;

    public Usuario() {
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String nombre, String correo, String codigoPerfil, String codigoDepartamento, String codigoSap, String folioUsuario, String clave, String asignacion, String asignacionusd, Date fechaAlta, Integer vigencia, String tarjetaCoorporativa, String estatus, String tarjetaGasolina, String admonPoliza, Date fechaAcceso) {
        this.nombre = nombre;
        this.correo = correo;
        this.codigoPerfil = codigoPerfil;
        this.codigoDepartamento = codigoDepartamento;
        this.codigoSap = codigoSap;
        this.folioUsuario = folioUsuario;
        this.clave = clave;
        this.asignacion = asignacion;
        this.asignacionusd = asignacionusd;
        this.fechaAlta = fechaAlta;
        this.vigencia = vigencia;
        this.tarjetaCoorporativa = tarjetaCoorporativa;
        this.estatus = estatus;
        this.tarjetaGasolina = tarjetaGasolina;
        this.admonPoliza = admonPoliza;
        this.fechaAcceso = fechaAcceso;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigoPerfil() {
        return this.codigoPerfil;
    }

    public void setCodigoPerfil(String codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    public String getCodigoDepartamento() {
        return this.codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoSap() {
        return this.codigoSap;
    }

    public void setCodigoSap(String codigoSap) {
        this.codigoSap = codigoSap;
    }

    public String getFolioUsuario() {
        return this.folioUsuario;
    }

    public void setFolioUsuario(String folioUsuario) {
        this.folioUsuario = folioUsuario;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getAsignacion() {
        return this.asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    public String getAsignacionusd() {
        return this.asignacionusd;
    }

    public void setAsignacionusd(String asignacionusd) {
        this.asignacionusd = asignacionusd;
    }

    public Date getFechaAlta() {
        return this.fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Integer getVigencia() {
        return this.vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public String getTarjetaCoorporativa() {
        return this.tarjetaCoorporativa;
    }

    public void setTarjetaCoorporativa(String tarjetaCoorporativa) {
        this.tarjetaCoorporativa = tarjetaCoorporativa;
    }

    public String getEstatus() {
        return this.estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getTarjetaGasolina() {
        return this.tarjetaGasolina;
    }

    public void setTarjetaGasolina(String tarjetaGasolina) {
        this.tarjetaGasolina = tarjetaGasolina;
    }

    public String getAdmonPoliza() {
        return this.admonPoliza;
    }

    public void setAdmonPoliza(String admonPoliza) {
        this.admonPoliza = admonPoliza;
    }

    public Date getFechaAcceso() {
        return this.fechaAcceso;
    }

    public void setFechaAcceso(Date fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }
}
