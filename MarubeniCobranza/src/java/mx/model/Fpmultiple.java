package mx.model;

import java.io.Serializable;

public class Fpmultiple implements Serializable {

    private int id;
    private String facturas;

    public Fpmultiple() {
    }

    public Fpmultiple(int id) {
        this.id = id;
    }

    public Fpmultiple(int id, String facturas) {
        this.id = id;
        this.facturas = facturas;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacturas() {
        return this.facturas;
    }

    public void setFacturas(String facturas) {
        this.facturas = facturas;
    }
}
