/*    */ package mx.report;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.sql.SQLException;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.view.ViewScoped;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ 
/*    */ @javax.inject.Named("polizaPreviewBean")
/*    */ @ViewScoped
/*    */ public class polizaPreviewBean implements Serializable
/*    */ {
/*    */   private String nombreUsuario;
/*    */   private String folioUsuario;
/*    */   
/*    */   public String getNombreUsuario()
/*    */   {
/* 20 */     return this.nombreUsuario;
/*    */   }
/*    */   
/*    */   public void setNombreUsuario(String nombreUsuario) {
/* 24 */     this.nombreUsuario = nombreUsuario;
/*    */   }
/*    */   
/*    */   public String getFolioUsuario() {
/* 28 */     return this.folioUsuario;
/*    */   }
/*    */   
/*    */   public void setFolioUsuario(String folioUsuario) {
/* 32 */     this.folioUsuario = folioUsuario;
/*    */   }
/*    */   
/*    */   public void polizaPreviewBean() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
/* 36 */     HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
/* 37 */     polizaPreview rCliente = new polizaPreview();
/* 38 */     FacesContext facesContext = FacesContext.getCurrentInstance();
/* 39 */     ServletContext servletContext = (ServletContext)facesContext.getExternalContext().getContext();
/* 40 */     String ruta = servletContext.getRealPath("/Report/polizaPreview.jasper");
/* 41 */     rCliente.getReporte(ruta, this.nombreUsuario = request.getParameter("frmLayoutPreview:codigo"), this.folioUsuario = request.getParameter("frmLayoutPreview:folio"));
/* 42 */     FacesContext.getCurrentInstance().responseComplete();
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\report\polizaPreviewBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */