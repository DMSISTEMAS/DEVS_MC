package mx.model;

import java.io.Serializable;

public class Avisocorreo implements Serializable {

    private int id;
    private String departamento;
    private String correo;

    public Avisocorreo() {
    }

    public Avisocorreo(int id) {
        this.id = id;
    }

    public Avisocorreo(int id, String departamento, String correo) {
        this.id = id;
        this.departamento = departamento;
        this.correo = correo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
