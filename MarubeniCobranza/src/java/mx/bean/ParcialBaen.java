package mx.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mx.dao.CuenM01Dao;
import mx.model.Cuenm01;
import org.primefaces.event.RowEditEvent;

@Named("parcialBean")
@ViewScoped
public class ParcialBaen implements Serializable {

    private List<Cuenm01> listaParciales;
    private Cuenm01 f;

    public ParcialBaen() {
        this.f = new Cuenm01();
    }

    public Cuenm01 getF() {
        return this.f;
    }

    public void setF(Cuenm01 f) {
        this.f = f;
    }

    public List<Cuenm01> getListaParciales() {
        return this.listaParciales;
    }

    public List<Cuenm01> listParciales() {
        CuenM01Dao cDao = new mx.impl.CuenM01DaoImpl();
        this.listaParciales = cDao.lsitaFacturasParciales();
        return this.listaParciales;
    }

    public void onRowEdit(RowEditEvent event) {
        Cuenm01 dato = (Cuenm01) event.getObject();
        if (dato.getNuevoImporte().doubleValue() > dato.getImporte().doubleValue()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Importe incorrecto"));
        }
    }

    public void onRowCancel(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Actualización cancelada"));
    }
}
