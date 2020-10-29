package mx.model;

import java.io.Serializable;

public class Vendedor implements Serializable {

    private String strcvevend;
    private String correo;
    private String nombre;

    public Vendedor() {
    }

    public Vendedor(String strcvevend) {
        this.strcvevend = strcvevend;
    }

    public Vendedor(String strcvevend, String correo, String nombre) {
        this.strcvevend = strcvevend;
        this.correo = correo;
        this.nombre = nombre;
    }

    public String getStrcvevend() {
        return this.strcvevend;
    }

    public void setStrcvevend(String strcvevend) {
        this.strcvevend = strcvevend;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
