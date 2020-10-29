/*    */ package mx.report;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.sf.jasperreports.engine.JRException;
/*    */ import net.sf.jasperreports.engine.JRExporterParameter;
/*    */ import net.sf.jasperreports.engine.JasperFillManager;
/*    */ import net.sf.jasperreports.engine.JasperPrint;
/*    */ import net.sf.jasperreports.engine.JasperReport;
/*    */ import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
/*    */ import net.sf.jasperreports.engine.util.JRLoader;
/*    */ 
/*    */ public class reportePolizaPagos extends mx.conexion.DAO
/*    */ {
/*    */   public void getReporte(String ruta, String folio)
/*    */   {
/* 21 */     Conectar();
/*    */     
/* 23 */     Map parameter = new HashMap();
/* 24 */     parameter.put("folio", folio);
/*    */     try {
/* 26 */       File file = new File(ruta);
/*    */       
/* 28 */       HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
/*    */       
/* 30 */       httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"reporte.xlsx\";");
/* 31 */       httpServletResponse.setHeader("Cache-Control", "no-cache");
/* 32 */       httpServletResponse.setHeader("Pragma", "no-cache");
/* 33 */       httpServletResponse.setDateHeader("Expires", 0L);
/* 34 */       httpServletResponse.setContentType("application/XLSX");
/*    */       
/* 36 */       JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile(file.getPath());
/*    */       
/* 38 */       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, getCn());
/*    */       
/* 40 */       JRXlsxExporter jrExporter = new JRXlsxExporter();
/* 41 */       jrExporter = new JRXlsxExporter();
/* 42 */       jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
/* 43 */       jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());
/*    */       
/* 45 */       if (jrExporter != null) {
/*    */         try {
/* 47 */           jrExporter.exportReport();
/*    */         } catch (JRException e) {
/* 49 */           e.printStackTrace();
/*    */         }
/*    */       }
/*    */       return;
/*    */     } catch (Exception e) {
/* 54 */       e.printStackTrace();
/*    */     } finally {
/* 56 */       if (getCn() != null) {
/*    */         try {
/* 58 */           Cerrar();
/*    */         } catch (Exception e) {
/* 60 */           e.printStackTrace();
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\report\reportePolizaPagos.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */