package mx.model;

import java.io.Serializable;

public class Bancos implements Serializable {

    private int id;
    private String nombre;
    private String cuenta;
    private String subcuenta;
    private String moneda;

    public Bancos() {
    }

    public Bancos(int id) {
        this.id = id;
    }

    public Bancos(int id, String nombre, String cuenta, String subcuenta, String moneda) {
        this.id = id;
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.subcuenta = subcuenta;
        this.moneda = moneda;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getSubcuenta() {
        return this.subcuenta;
    }

    public void setSubcuenta(String subcuenta) {
        this.subcuenta = subcuenta;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
