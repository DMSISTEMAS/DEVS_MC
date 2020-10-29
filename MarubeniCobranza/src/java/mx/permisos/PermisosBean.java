package mx.permisos;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import mx.model.Usuario;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@javax.inject.Named("permisosBean")
@ViewScoped
public class PermisosBean implements java.io.Serializable {

    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");

    private MenuModel model;

    @PostConstruct
    public void init() {
        this.model = new DefaultMenuModel();

        if (this.us.getCodigoPerfil().equals("Administrador")) {
            DefaultSubMenu primerSubmenu = new DefaultSubMenu("Inicio");

            DefaultMenuItem item = new DefaultMenuItem("Inicio");
            item.setOutcome("/Views/Pagos/Pagos.jsf");
            item.setIcon("ui-icon-home");
            primerSubmenu.addElement(item);

            this.model.addElement(primerSubmenu);

            DefaultSubMenu quintoSubmenu = new DefaultSubMenu("Pagos");
            item = new DefaultMenuItem("Control de pagos");
            item.setIcon("ui-icon-disk");
            item.setOutcome("/Views/Pagos/Pagos.jsf");
            quintoSubmenu.addElement(item);

            item = new DefaultMenuItem("Reporte pagos");
            item.setIcon("ui-icon-disk");
            item.setOutcome("/Views/Pagos/Reporte.jsf");
            quintoSubmenu.addElement(item);

            item = new DefaultMenuItem("Administrar pólizas");
            item.setIcon("ui-icon-disk");
            item.setOutcome("/Views/Pagos/ReportePol.jsf");
            quintoSubmenu.addElement(item);

            item = new DefaultMenuItem("Envío de correos");
            item.setIcon("ui-icon-disk");
            item.setOutcome("/Views/Pagos/Correos.jsf");
            quintoSubmenu.addElement(item);

            this.model.addElement(quintoSubmenu);
        }
    }

    public MenuModel getModel() {
        return this.model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void save() {
        addMessage("Success", "Data saved");
    }

    public void update() {
        addMessage("Success", "Data updated");
    }

    public void delete() {
        addMessage("Success", "Data deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
