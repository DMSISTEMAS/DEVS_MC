package mx.model;

import java.io.Serializable;

public class Lista implements Serializable {

    private String conceptos;
    private Integer idConcepto;
    private String descripcion;

    public Lista() {
    }

    public Lista(String conceptos) {
        this.conceptos = conceptos;
    }

    public Lista(String conceptos, Integer idConcepto, String descripcion) {
        this.conceptos = conceptos;
        this.idConcepto = idConcepto;
        this.descripcion = descripcion;
    }

    public String getConceptos() {
        return this.conceptos;
    }

    public void setConceptos(String conceptos) {
        this.conceptos = conceptos;
    }

    public Integer getIdConcepto() {
        return this.idConcepto;
    }

    public void setIdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
