/*    */ package mx.report;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.view.ViewScoped;
/*    */ import javax.inject.Named;
/*    */ import javax.servlet.ServletContext;
/*    */ import mx.conexion.DAO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Named("reporteGastoBean")
/*    */ @ViewScoped
/*    */ public class reporteGastoBean
/*    */   extends DAO
/*    */   implements Serializable
/*    */ {
/*    */   private String nombreUsuario;
/*    */   private String folioUsuario;
/*    */   private Integer conteo;
/* 27 */   private String pathReporte = "";
/*    */   
/*    */   public String getNombreUsuario() {
/* 30 */     return this.nombreUsuario;
/*    */   }
/*    */   
/*    */   public void setNombreUsuario(String nombreUsuario) {
/* 34 */     this.nombreUsuario = nombreUsuario;
/*    */   }
/*    */   
/*    */   public String getFolioUsuario() {
/* 38 */     return this.folioUsuario;
/*    */   }
/*    */   
/*    */   public void setFolioUsuario(String folioUsuario) {
/* 42 */     this.folioUsuario = folioUsuario;
/*    */   }
/*    */   
/*    */   public Integer getConteo() {
/* 46 */     return this.conteo;
/*    */   }
/*    */   
/*    */   public void setConteo(Integer conteo) {
/* 50 */     this.conteo = conteo;
/*    */   }
/*    */   
/*    */   public String getPathReporte() {
/* 54 */     return this.pathReporte;
/*    */   }
/*    */   
/*    */   public void setPathReporte(String pathReporte) {
/* 58 */     this.pathReporte = pathReporte;
/*    */   }
/*    */   
/*    */   public void reporteGastoBean() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
/* 62 */     Conectar();
/* 63 */     Statement st = getCn().createStatement();
/* 64 */     ResultSet rs = st.executeQuery("SELECT COUNT(nombreConcepto) as conteo  FROM concepto WHERE nombreUsuario='" + this.nombreUsuario + "' AND folioUsuario='" + this.folioUsuario + "'");
/* 65 */     while (rs.next()) {
/* 66 */       this.conteo = Integer.valueOf(rs.getInt("conteo"));
/* 67 */       if (this.conteo.intValue() > 0) {
/* 68 */         this.pathReporte = "/Report/reporte.jasper";
/*    */       } else {
/* 70 */         this.pathReporte = "/Report/reporteDayAllowance.jasper";
/*    */       }
/*    */     }
/*    */     
/* 74 */     reporteGasto rCliente = new reporteGasto();
/* 75 */     FacesContext facesContext = FacesContext.getCurrentInstance();
/* 76 */     ServletContext servletContext = (ServletContext)facesContext.getExternalContext().getContext();
/* 77 */     String ruta = servletContext.getRealPath(this.pathReporte);
/* 78 */     rCliente.getReporte(ruta, this.nombreUsuario, this.folioUsuario);
/* 79 */     FacesContext.getCurrentInstance().responseComplete();
/* 80 */     Cerrar();
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\report\reporteGastoBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */