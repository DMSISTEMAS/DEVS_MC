package mx.model;

import java.io.Serializable;

public class Departamento implements Serializable {

    private String codigoDep;

    public Departamento() {
    }

    public Departamento(String codigoDep) {
        this.codigoDep = codigoDep;
    }

    public String getCodigoDep() {
        return this.codigoDep;
    }

    public void setCodigoDep(String codigoDep) {
        this.codigoDep = codigoDep;
    }
}
