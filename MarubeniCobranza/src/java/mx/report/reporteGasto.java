/*    */ package mx.report;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.sql.SQLException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import mx.conexion.DAO;
/*    */ import net.sf.jasperreports.engine.JRException;
/*    */ import net.sf.jasperreports.engine.JRExporter;
/*    */ import net.sf.jasperreports.engine.JRExporterParameter;
/*    */ import net.sf.jasperreports.engine.JasperFillManager;
/*    */ import net.sf.jasperreports.engine.JasperPrint;
/*    */ import net.sf.jasperreports.engine.JasperReport;
/*    */ import net.sf.jasperreports.engine.export.JRPdfExporter;
/*    */ import net.sf.jasperreports.engine.util.JRLoader;
/*    */ 
/*    */ public class reporteGasto extends DAO
/*    */ {
/*    */   public void getReporte(String ruta, String nombre, String folio) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
/*    */   {
/* 25 */     Conectar();
/*    */     
/* 27 */     Map parameter = new HashMap();
/* 28 */     parameter.put("nombreReporte", nombre);
/* 29 */     parameter.put("nombreFolio", folio);
/*    */     try
/*    */     {
/* 32 */       File file = new File(ruta);
/*    */       
/* 34 */       HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 39 */       httpServletResponse.setDateHeader("Expires", 0L);
/* 40 */       httpServletResponse.setContentType("application/PDF");
/*    */       
/* 42 */       JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile(file.getPath());
/*    */       
/* 44 */       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, getCn());
/*    */       
/* 46 */       JRExporter jrExporter = null;
/* 47 */       jrExporter = new JRPdfExporter();
/* 48 */       jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
/* 49 */       jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());
/*    */       
/*    */ 
/*    */ 
/* 53 */       if (jrExporter != null) {
/*    */         try {
/* 55 */           jrExporter.exportReport();
/*    */         }
/*    */         catch (JRException localJRException) {}
/*    */       }
/*    */       return;
/*    */     }
/*    */     catch (JRException|IOException localJRException1) {}finally {
/* 62 */       if (getCn() != null) {
/*    */         try {
/* 64 */           Cerrar();
/*    */         }
/*    */         catch (Exception localException2) {}
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\report\reporteGasto.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */