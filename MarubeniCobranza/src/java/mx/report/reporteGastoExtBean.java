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
/*    */ @Named("reporteGastoExtBean")
/*    */ @ViewScoped
/*    */ public class reporteGastoExtBean
/*    */   extends DAO implements Serializable
/*    */ {
/*    */   private String nombreUsuario;
/*    */   private String folioUsuario;
/*    */   private Integer conteo;
/* 23 */   private String pathReporte = "";
/*    */   
/*    */   public String getNombreUsuario() {
/* 26 */     return this.nombreUsuario;
/*    */   }
/*    */   
/*    */   public void setNombreUsuario(String nombreUsuario) {
/* 30 */     this.nombreUsuario = nombreUsuario;
/*    */   }
/*    */   
/*    */   public String getFolioUsuario() {
/* 34 */     return this.folioUsuario;
/*    */   }
/*    */   
/*    */   public void setFolioUsuario(String folioUsuario) {
/* 38 */     this.folioUsuario = folioUsuario;
/*    */   }
/*    */   
/*    */   public Integer getConteo() {
/* 42 */     return this.conteo;
/*    */   }
/*    */   
/*    */   public void setConteo(Integer conteo) {
/* 46 */     this.conteo = conteo;
/*    */   }
/*    */   
/*    */   public String getPathReporte() {
/* 50 */     return this.pathReporte;
/*    */   }
/*    */   
/*    */   public void setPathReporte(String pathReporte) {
/* 54 */     this.pathReporte = pathReporte;
/*    */   }
/*    */   
/*    */   public void reporteGastoExtBean() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
/* 58 */     Conectar();
/* 59 */     Statement st = getCn().createStatement();
/* 60 */     ResultSet rs = st.executeQuery("SELECT COUNT(nombreConcepto) as conteo  FROM concepto WHERE nombreUsuario='" + this.nombreUsuario + "' AND folioUsuario='" + this.folioUsuario + "'");
/* 61 */     while (rs.next()) {
/* 62 */       this.conteo = Integer.valueOf(rs.getInt("conteo"));
/* 63 */       if (this.conteo.intValue() > 0) {
/* 64 */         this.pathReporte = "/Report/reporteExt.jasper";
/*    */       } else {
/* 66 */         this.pathReporte = "/Report/reporteExtDayAllowance.jasper";
/*    */       }
/*    */     }
/* 69 */     reporteExtGasto rCliente = new reporteExtGasto();
/* 70 */     FacesContext facesContext = FacesContext.getCurrentInstance();
/* 71 */     ServletContext servletContext = (ServletContext)facesContext.getExternalContext().getContext();
/* 72 */     String ruta = servletContext.getRealPath(this.pathReporte);
/* 73 */     rCliente.getReporte(ruta, this.nombreUsuario, this.folioUsuario);
/* 74 */     FacesContext.getCurrentInstance().responseComplete();
/* 75 */     Cerrar();
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\report\reporteGastoExtBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */