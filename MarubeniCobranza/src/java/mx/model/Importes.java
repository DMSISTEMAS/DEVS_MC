package mx.model;

public class Importes {

    private Double mxn;
    private Double usd;

    public Importes() {
    }

    public Importes(Double mxn, Double usd) {
        this.mxn = mxn;
        this.usd = usd;
    }

    public Double getMxn() {
        return this.mxn;
    }

    public void setMxn(Double mxn) {
        this.mxn = mxn;
    }

    public Double getUsd() {
        return this.usd;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }
}
