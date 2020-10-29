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
/*    */ import net.sf.jasperreports.engine.JasperReport;
/*    */ import net.sf.jasperreports.engine.util.JRLoader;
/*    */ 
/*    */ public class reporteExtGasto extends mx.conexion.DAO
/*    */ {
/*    */   public void getReporte(String ruta, String nombre, String folio) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
/*    */   {
/* 20 */     Conectar();
/*    */     
/* 22 */     Map parameter = new HashMap();
/* 23 */     parameter.put("nombreReporte", nombre);
/* 24 */     parameter.put("nombreFolio", folio);
/*    */     try
/*    */     {
/* 27 */       File file = new File(ruta);
/*    */       
/* 29 */       HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
/*    */       
/*    */ 
/* 32 */       httpServletResponse.setHeader("Cache-Control", "no-cache");
/* 33 */       httpServletResponse.setHeader("Pragma", "no-cache");
/* 34 */       httpServletResponse.setDateHeader("Expires", 0L);
/* 35 */       httpServletResponse.setContentType("application/PDF");
/*    */       
/* 37 */       JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile(file.getPath());
/*    */       
/* 39 */       net.sf.jasperreports.engine.JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(jasperReport, parameter, getCn());
/*    */       
/* 41 */       JRExporter jrExporter = null;
/* 42 */       jrExporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
/* 43 */       jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
/* 44 */       jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());
/*    */       
/*    */ 
/*    */ 
/* 48 */       if (jrExporter != null) {
/*    */         try {
/* 50 */           jrExporter.exportReport();
/*    */         }
/*    */         catch (JRException localJRException) {}
/*    */       }
/*    */       return;
/*    */     }
/*    */     catch (JRException|java.io.IOException localJRException1) {}finally {
/* 57 */       if (getCn() != null) {
/*    */         try {
/* 59 */           Cerrar();
/*    */         }
/*    */         catch (Exception localException2) {}
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\report\reporteExtGasto.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */