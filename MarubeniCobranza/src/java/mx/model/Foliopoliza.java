package mx.model;

import java.util.Date;

public class Foliopoliza implements java.io.Serializable {

    private int idpol;
    private Date fechaPoliza;
    private String usuario;

    public Foliopoliza() {
    }

    public Foliopoliza(int idpol) {
        this.idpol = idpol;
    }

    public Foliopoliza(int idpol, Date fechaPoliza, String usuario) {
        this.idpol = idpol;
        this.fechaPoliza = fechaPoliza;
        this.usuario = usuario;
    }

    public int getIdpol() {
        return this.idpol;
    }

    public void setIdpol(int idpol) {
        this.idpol = idpol;
    }

    public Date getFechaPoliza() {
        return this.fechaPoliza;
    }

    public void setFechaPoliza(Date fechaPoliza) {
        this.fechaPoliza = fechaPoliza;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
