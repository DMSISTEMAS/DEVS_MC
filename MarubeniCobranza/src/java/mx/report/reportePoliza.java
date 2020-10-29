/*    */ package mx.report;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
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
/*    */ import net.sf.jasperreports.engine.export.JRTextExporter;
/*    */ import net.sf.jasperreports.engine.export.JRTextExporterParameter;
/*    */ import net.sf.jasperreports.engine.util.JRLoader;
/*    */ 
/*    */ public class reportePoliza
/*    */   extends DAO
/*    */ {
/*    */   public void getReporte(String ruta, String nombre, String folio) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
/*    */   {
/* 28 */     Conectar();
/* 29 */     Map parameter = new HashMap();
/* 30 */     parameter.put("nombreReporte", nombre);
/* 31 */     parameter.put("nombreFolio", folio);
/*    */     try
/*    */     {
/* 34 */       File file = new File(ruta);
/*    */       
/* 36 */       HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
/*    */       
/* 38 */       httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\\Poliza-" + nombre + "-" + folio + ".txt");
/* 39 */       httpServletResponse.setHeader("Cache-Control", "no-cache");
/* 40 */       httpServletResponse.setHeader("Pragma", "no-cache");
/* 41 */       httpServletResponse.setDateHeader("Expires", 0L);
/* 42 */       httpServletResponse.setContentType("application/TEXT");
/*    */       
/* 44 */       JasperReport jasperReport = (JasperReport)JRLoader.loadObjectFromFile(file.getPath());
/*    */       
/* 46 */       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, getCn());
/*    */       
/* 48 */       JRExporter jrExporter = null;
/* 49 */       jrExporter = new JRTextExporter();
/* 50 */       jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
/* 51 */       jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());
/* 52 */       jrExporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH, new Float(2.5D));
/* 53 */       jrExporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT, new Float(8.0F));
/*    */       
/* 55 */       if (jrExporter != null) {
/*    */         try {
/* 57 */           jrExporter.exportReport();
/*    */         } catch (JRException e) {
/* 59 */           System.err.println(e.getMessage());
/*    */         }
/*    */       }
/*    */       return;
/*    */     }
/*    */     catch (JRException|IOException localJRException1) {}finally {
/* 65 */       if (getCn() != null) {
/*    */         try {
/* 67 */           Cerrar();
/*    */         } catch (SQLException e) {
/* 69 */           System.err.println(e.getMessage());
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppCobranza (2).war!\WEB-INF\classes\mx\report\reportePoliza.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */