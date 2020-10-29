/*    */ package mx.report;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.view.ViewScoped;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ 
/*    */ @javax.inject.Named("reportePolizaBean")
/*    */ @ViewScoped
/*    */ public class reportePolizaBean implements java.io.Serializable
/*    */ {
/*    */   private String nombreUsuario;
/*    */   private String folioUsuario;
/*    */   
/*    */   public String getNombreUsuario()
/*    */   {
/* 19 */     return this.nombreUsuario;
/*    */   }
/*    */   
/*    */   public void setNombreUsuario(String nombreUsuario) {
/* 23 */     this.nombreUsuario = nombreUsuario;
/*    */   }
/*    */   
/*    */   public String getFolioUsuario() {
/* 27 */     return this.folioUsuario;
/*    */   }
/*    */   
/*    */   public void setFolioUsuario(String folioUsuario) {
/* 31 */     this.folioUsuario = folioUsuario;
/*    */   }
/*    */   
/*    */   public void reportePolizaBean() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
/* 35 */     HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
/* 36 */     reportePoliza rPoliza = new reportePoliza();
/* 37 */     FacesContext facesContext = FacesContext.getCurrentInstance();
/* 38 */     ServletContext servletContext = (ServletContext)facesContext.getExternalContext().getContext();
/* 39 */     String ruta = servletContext.getRealPath("/Report/text.jasper");
/* 40 */     rPoliza.getReporte(ruta, this.nombreUsuario = request.getParameter("frmLayout:codigo"), this.folioUsuario = request.getParameter("frmLayout:folio"));
/* 41 */     FacesContext.getCurrentInstance().responseComplete();
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\report\reportePolizaBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */