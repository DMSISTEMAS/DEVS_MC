/*    */ package mx.report;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.sql.SQLException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.sf.jasperreports.engine.JRException;
/*    */ import net.sf.jasperreports.engine.JRExporter;
/*    */ import net.sf.jasperreports.engine.JRExporterParameter;
/*    */ import net.sf.jasperreports.engine.JasperFillManager;
/*    */ import net.sf.jasperreports.engine.JasperReport;
/*    */ import net.sf.jasperreports.engine.util.JRLoader;
/*    */ 
/*    */ public class polizaPreview extends mx.conexion.DAO
/*    */ {
/*    */   public void getReporte(String ruta, String nombre, String folio) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
/*    */   {
/* 21 */     Conectar();
/*    */     
/*    */ 
/* 24 */     Map parameter = new HashMap();
/* 25 */     parameter.put("nombreReporte", nombre);
/* 26 */     parameter.put("nombreFolio", folio);
/*    */     try
/*    */     {
/* 29 */       File file = new File(ruta);
/*    */       
/* 31 */       HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 36 */       httpServletResponse.setDateHeader("Expires", 0L);
/* 37 */       httpServletResponse.setContentType("application/PDF");
/*    */       
/* 39 */       JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile(file.getPath());
/*    */       
/* 41 */       net.sf.jasperreports.engine.JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, getCn());
/*    */       
/* 43 */       JRExporter jrExporter = null;
/* 44 */       jrExporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
/* 45 */       jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
/* 46 */       jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());
/*    */       
/*    */ 
/*    */ 
/* 50 */       if (jrExporter != null) {
/*    */         try {
/* 52 */           jrExporter.exportReport();
/*    */         }
/*    */         catch (JRException localJRException) {}
/*    */       }
/*    */       return;
/*    */     }
/*    */     catch (JRException|java.io.IOException localJRException1) {}finally {
/* 59 */       if (getCn() != null) {
/*    */         try {
/* 61 */           Cerrar();
/*    */         }
/*    */         catch (Exception localException2) {}
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\report\polizaPreview.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */