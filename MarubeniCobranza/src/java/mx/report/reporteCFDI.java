/*    */ package mx.report;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.sql.SQLException;
/*    */ import java.util.Map;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.sf.jasperreports.engine.JRException;
/*    */ import net.sf.jasperreports.engine.JRExporter;
/*    */ import net.sf.jasperreports.engine.JRExporterParameter;
/*    */ import net.sf.jasperreports.engine.JasperReport;
/*    */ import net.sf.jasperreports.engine.util.JRLoader;
/*    */ 
/*    */ public class reporteCFDI extends mx.conexion.DAO
/*    */ {
/*    */   public void getReporte(String ruta, String uuid) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
/*    */   {
/* 18 */     Conectar();
/*    */     
/* 20 */     Map parameter = new java.util.HashMap();
/* 21 */     parameter.put("uuid", uuid);
/*    */     
/*    */     try
/*    */     {
/* 25 */       File file = new File(ruta);
/*    */       
/* 27 */       HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 32 */       httpServletResponse.setDateHeader("Expires", 0L);
/* 33 */       httpServletResponse.setContentType("application/PDF");
/*    */       
/* 35 */       JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile(file.getPath());
/*    */       
/* 37 */       net.sf.jasperreports.engine.JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(jasperReport, parameter, getCn());
/*    */       
/* 39 */       JRExporter jrExporter = null;
/* 40 */       jrExporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
/* 41 */       jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
/* 42 */       jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());
/*    */       
/*    */ 
/*    */ 
/* 46 */       if (jrExporter != null) {
/*    */         try {
/* 48 */           jrExporter.exportReport();
/*    */         }
/*    */         catch (JRException localJRException) {}
/*    */       }
/*    */       return;
/*    */     }
/*    */     catch (JRException|java.io.IOException localJRException1) {}finally {
/* 55 */       if (getCn() != null) {
/*    */         try {
/* 57 */           Cerrar();
/*    */         }
/*    */         catch (Exception localException2) {}
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\report\reporteCFDI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */