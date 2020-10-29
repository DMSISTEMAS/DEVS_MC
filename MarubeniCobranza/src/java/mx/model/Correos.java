package mx.model;

import java.io.Serializable;

public class Correos implements Serializable {

    private int id;
    private String strcvevend;
    private String correoAsociado;

    public Correos() {
    }

    public Correos(int id) {
        this.id = id;
    }

    public Correos(int id, String strcvevend, String correoAsociado) {
        this.id = id;
        this.strcvevend = strcvevend;
        this.correoAsociado = correoAsociado;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrcvevend() {
        return this.strcvevend;
    }

    public void setStrcvevend(String strcvevend) {
        this.strcvevend = strcvevend;
    }

    public String getCorreoAsociado() {
        return this.correoAsociado;
    }

    public void setCorreoAsociado(String correoAsociado) {
        this.correoAsociado = correoAsociado;
    }
}
