/*    */ package mx.permisos;
/*    */ 
/*    */ import java.util.Map;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.view.ViewScoped;
/*    */ import mx.model.Usuario;
/*    */ import org.primefaces.model.menu.DefaultMenuItem;
/*    */ import org.primefaces.model.menu.DefaultMenuModel;
/*    */ import org.primefaces.model.menu.DefaultSubMenu;
/*    */ import org.primefaces.model.menu.MenuModel;
/*    */ 
/*    */ @javax.inject.Named("permisosBean")
/*    */ @ViewScoped
/*    */ public class PermisosBean implements java.io.Serializable
/*    */ {
/* 19 */   Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/*    */   
/*    */   private MenuModel model;
/*    */   
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 27 */     this.model = new DefaultMenuModel();
/*    */     
/* 29 */     if (this.us.getCodigoPerfil().equals("Administrador"))
/*    */     {
/* 31 */       DefaultSubMenu primerSubmenu = new DefaultSubMenu("Inicio");
/*    */       
/* 33 */       DefaultMenuItem item = new DefaultMenuItem("Inicio");
/* 34 */       item.setOutcome("/Views/Pagos/Pagos.jsf");
/* 35 */       item.setIcon("ui-icon-home");
/* 36 */       primerSubmenu.addElement(item);
/*    */       
/* 38 */       this.model.addElement(primerSubmenu);
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 43 */       DefaultSubMenu quintoSubmenu = new DefaultSubMenu("Pagos");
/* 44 */       item = new DefaultMenuItem("Control de pagos");
/* 45 */       item.setIcon("ui-icon-disk");
/* 46 */       item.setOutcome("/Views/Pagos/Pagos.jsf");
/* 47 */       quintoSubmenu.addElement(item);
/*    */       
/* 49 */       item = new DefaultMenuItem("Reporte pagos");
/* 50 */       item.setIcon("ui-icon-disk");
/* 51 */       item.setOutcome("/Views/Pagos/Reporte.jsf");
/* 52 */       quintoSubmenu.addElement(item);
/*    */       
/* 54 */       item = new DefaultMenuItem("Administrar pólizas");
/* 55 */       item.setIcon("ui-icon-disk");
/* 56 */       item.setOutcome("/Views/Pagos/ReportePol.jsf");
/* 57 */       quintoSubmenu.addElement(item);
/*    */       
/* 59 */       item = new DefaultMenuItem("Envío de correos");
/* 60 */       item.setIcon("ui-icon-disk");
/* 61 */       item.setOutcome("/Views/Pagos/Correos.jsf");
/* 62 */       quintoSubmenu.addElement(item);
/*    */       
/* 64 */       this.model.addElement(quintoSubmenu);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public MenuModel getModel()
/*    */   {
/* 72 */     return this.model;
/*    */   }
/*    */   
/*    */   public void setModel(MenuModel model) {
/* 76 */     this.model = model;
/*    */   }
/*    */   
/*    */   public void save() {
/* 80 */     addMessage("Success", "Data saved");
/*    */   }
/*    */   
/*    */   public void update() {
/* 84 */     addMessage("Success", "Data updated");
/*    */   }
/*    */   
/*    */   public void delete() {
/* 88 */     addMessage("Success", "Data deleted");
/*    */   }
/*    */   
/*    */   public void addMessage(String summary, String detail) {
/* 92 */     FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
/* 93 */     FacesContext.getCurrentInstance().addMessage(null, message);
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\permisos\PermisosBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */