package mx.bean;

import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import mx.conexion.DAO;
import mx.dao.CorreosDao;
import mx.dao.PagosDao;
import mx.dao.VendedorDao;
import mx.impl.CorreosDaoImpl;
import mx.impl.PagosDaoImpl;
import mx.impl.VendedorDaoImpl;
import mx.model.Pagos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Named("mailPagoBean")
@ViewScoped
public class AvisoPagoBean extends DAO implements Serializable {

    private Pagos pagos;
    private List<Pagos> listarAvisosPagos;
    private List<String> listarUsuariosPago;
    private final String path = "C://img//";
    private List<String> listaCorreos;
    private List<String> listaVendedor;
    private int dia;
    private int mes;
    private int año;
    private Calendar hoy;
    private String fecPago;
    private Double importeMxn = Double.valueOf(0.0D);
    private Double importeUsd = Double.valueOf(0.0D);
    private List<Pagos> listarFolios;
    private String facturas;

    public AvisoPagoBean() {
        this.pagos = new Pagos();
    }

    public Pagos getPagos() {
        return this.pagos;
    }

    public void setPagos(Pagos pagos) {
        this.pagos = pagos;
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return this.año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Calendar getHoy() {
        return this.hoy;
    }

    public void setHoy(Calendar hoy) {
        this.hoy = hoy;
    }

    public String getFecPago() {
        return this.fecPago;
    }

    public void setFecPago(String fecPago) {
        this.fecPago = fecPago;
    }

    public Double getImporteMxn() {
        return this.importeMxn;
    }

    public void setImporteMxn(Double importeMxn) {
        this.importeMxn = importeMxn;
    }

    public Double getImporteUsd() {
        return this.importeUsd;
    }

    public void setImporteUsd(Double importeUsd) {
        this.importeUsd = importeUsd;
    }

    public List<Pagos> getListarFolios() {
        return this.listarFolios;
    }

    public String getFacturas() {
        return this.facturas;
    }

    public void setFacturas(String facturas) {
        this.facturas = facturas;
    }

    public List<Pagos> getListarAvisosPagos() {
        PagosDao pDao = new PagosDaoImpl();
        this.listarAvisosPagos = pDao.listarFacturasEnvioCorreos();
        return this.listarAvisosPagos;
    }

    public List<String> getListarUsuariosPago() {
        PagosDao lDao = new PagosDaoImpl();
        this.listarUsuariosPago = lDao.listaUsuariosAvisoPago();
        return this.listarUsuariosPago;
    }

    public void actualizarEnvio() throws SQLException {
        PagosDao pDao = new PagosDaoImpl();
        for (int i = 0; i < this.listarFolios.size(); i++) {
            try {
                if (((Pagos) this.listarFolios.get(i)).getProcesado().equals(Boolean.valueOf(true))) {
                    pDao.updateFactf01(((Pagos) this.listarFolios.get(i)).getPagoMultiple().intValue(), "NO");
                    System.out.println(((Pagos) this.listarFolios.get(i)).getPagoMultiple());
                }
            } catch (Exception e) {
                System.out.println("null");
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PAGOS", "SOLICITUD PROCESADA"));
        buscarPagos();
    }

    public void generarPDFReporte(String vendedor) {
        try {
            Conectar();

            Map parameter = new HashMap();
            parameter.put("vendedor", vendedor);
            URL in = getClass().getResource("/mx/report/report1AvisoPago.jasper");
            JasperReport jr = (JasperReport) JRLoader.loadObject(in);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, getCn());
            JasperExportManager.exportReportToPdfFile(jp, "C://img//reportePagos.pdf");
            Cerrar();
        } catch (SQLException | JRException ex) {
            Logger.getLogger(AvisoPagoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void procesarInfo() throws MessagingException, SQLException {
        actualizarEnvio();
        getListarUsuariosPago();
        PagosDao proDao = new PagosDaoImpl();
        for (int j = 0; j < this.listarUsuariosPago.size(); j++) {
            String depto = (String) this.listarUsuariosPago.get(j);
            generarPDFReporte(depto);
            proDao.updateEnvio(depto);
            enviarCorreo(depto);
//            generarPDFReporte(depto.substring(0, 2));
//            proDao.updateEnvio(depto.substring(0, 2));
//            enviarCorreo(depto.substring(0, 2));
            File fDelete = new File("C://img//reportePagos.pdf");
            fDelete.delete();
        }
    }

    public List<Pagos> buscarPagos() throws SQLException {
        this.importeMxn = Double.valueOf(0.0D);
        this.importeUsd = Double.valueOf(0.0D);
        if (this.listarFolios != null) {
            this.listarFolios.clear();
        }
        Conectar();
        PreparedStatement ps = getCn().prepareStatement("SELECT DISTINCT SUM(IMPORTE) AS IMPORTE, TCAMBIO, MONEDA, FECHA_PAGO, PAGO_MULTIPLE, BANCO, DEPTO, ESTADO, SUBCUENTA, CTACLIENTESAP, SUM(IMPORTEUSD)AS IMPORTEUSD, CLIENTE FROM pagos WHERE ENVIADO IS NULL  GROUP BY PAGO_MULTIPLE, BANCO,TCAMBIO,MONEDA,FECHA_PAGO,DEPTO,ESTADO,SUBCUENTA,CTACLIENTESAP,CLIENTE");

        ResultSet rs = ps.executeQuery();
        if (!rs.isBeforeFirst()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PAGOS", "No hay pagos pendientes para envío de correos"));
        } else {
            this.listarFolios = null;
            this.listarFolios = new ArrayList();
            while (rs.next()) {
                this.pagos = new Pagos();
                this.pagos.setPagoMultiple(Integer.valueOf(rs.getInt("PAGO_MULTIPLE")));
                this.pagos.setImporte(Double.valueOf(rs.getDouble("IMPORTE")));
                this.pagos.setTcambio(Double.valueOf(rs.getDouble("TCAMBIO")));
                this.pagos.setMoneda(Integer.valueOf(rs.getInt("MONEDA")));
                this.pagos.setFechaPago(rs.getDate("FECHA_PAGO"));
                this.pagos.setBanco(rs.getString("BANCO"));
                this.pagos.setDepto(rs.getString("DEPTO"));
                this.pagos.setEstado(rs.getString("ESTADO"));
                this.pagos.setSubcuenta(rs.getString("SUBCUENTA"));
                this.pagos.setCtaclientesap(rs.getString("CTACLIENTESAP"));
                this.pagos.setImporteusd(Double.valueOf(rs.getDouble("IMPORTEUSD")));
                this.pagos.setCliente(rs.getString("CLIENTE"));
                Conectar();
                PreparedStatement ps2 = getCn().prepareStatement("SELECT FACTURAS FROM fpmultiple WHERE ID='" + this.pagos.getPagoMultiple() + "'");
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    this.facturas = rs2.getString("FACTURAS").replace("[", "").replace("]", "");
                }
                this.pagos.setNoFactura(this.facturas);
                this.listarFolios.add(this.pagos);
            }
        }

        Cerrar();
        return this.listarFolios;
    }

    public void enviarCorreo(String clave) throws MessagingException {
        this.listaCorreos = new ArrayList();
        this.listaVendedor = new ArrayList();
        CorreosDao cDao = new CorreosDaoImpl();
        this.listaCorreos = cDao.listaCorreos(clave);
        VendedorDao vDao = new VendedorDaoImpl();
        this.listaVendedor = vDao.listaVendedor(clave);
        this.hoy = Calendar.getInstance();
        this.dia = this.hoy.get(7);
        this.hoy.add(5, 10);
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MMMM-yyyy");
        this.fecPago = formateador.format(this.hoy.getTime());
        Properties props = new Properties();
        props.put("mail.smtp.host", "mail.grupocomercialtria.com.mx");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "alertas@grupocomercialtria.com.mx");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(true);
        BodyPart texto = new MimeBodyPart();
        texto.setContent("<html><head><title></title></head><body><table width='678' height='315' border='0' bordercolor='#0000FF' bgcolor='#FFFFFF'><tr><td height='10' colspan='3' bordercolor='#FFFFFF'><img src='cid:azul' width='20%'/></td></tr><tr><td colspan='3' bordercolor='#FFFFFF'><p align='left' style='font-family:calibri; font-size:17px'><font color='#086A87'>Se han registrado pagos, ver PDF anexo: </font><br><br><b><font color='#000000'>Emitir el complemento de pago antes de: " + this.fecPago + ". </font></b><br></tr><tr><td width='425' bordercolor='#FFFFFF'><p align='left' style='font-family:calibri; font-size:17px'><br><font color='#17202a'>Sistema de Pagos | </font><font color='#E60013'>Marubeni M&eacute;xico, S.A. de C.V.</font><br><a href='http://etiquetas.marubeni.com.mx' target='_blank'><img src='cid:image' width='45%'/></a></td><td width='122' bordercolor='#FFFFFF'></td><td width='222' rowspan='2' bordercolor='#FFFFFF'></td></tr><tr><td colspan='2' bordercolor='#17202a'><br><br><p align='center' style='font-family:calibri; font-size:15px'><font color='#086A87'><br> Mensaje enviado desde el Sistema de Pagos Marubeni.</font></p></td></tr></table></body></html>", "text/html");

        BodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(new DataHandler(new FileDataSource("C://img//reportePagos.pdf")));
        adjunto.setFileName("Reporte_de_Pagos.pdf");

        MimeMultipart multiParte = new MimeMultipart();
        BodyPart imagen = new MimeBodyPart();
        BodyPart imagen2 = new MimeBodyPart();
        DataSource fds = new FileDataSource("C:\\img\\marubeni-logo.png");
        DataSource fds1 = new FileDataSource("C:\\img\\azul.png");
        imagen.setDataHandler(new DataHandler(fds));
        imagen2.setDataHandler(new DataHandler(fds1));
        imagen.setHeader("Content-ID", "<image>");
        imagen2.setHeader("Content-ID", "<azul>");

        multiParte.addBodyPart(texto);
        multiParte.addBodyPart(adjunto);
        multiParte.addBodyPart(imagen);
        multiParte.addBodyPart(imagen2);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress("alertas@grupocomercialtria.com.mx"));

        String address = this.listaCorreos.toString();
        String addressA = address.replace("[", "");
        String addressB = addressA.replace("]", "");
        String[] recipientList = addressB.split(",");
        InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
        int counter = 0;
        for (String recipient : recipientList) {
            recipientAddress[counter] = new InternetAddress(recipient.trim());
            counter++;
        }

//        System.out.println(Arrays.toString(recipientAddress));
//        System.out.println(Arrays.toString(recipientAddress));
        message.addRecipients(Message.RecipientType.TO, recipientAddress);
        message.addRecipients(Message.RecipientType.CC, "Martinez-R@marubeni.com");
        message.addRecipients(Message.RecipientType.CC, "Solano-H@marubeni.com");
        message.addRecipients(Message.RecipientType.CC, "Nakasone-A@marubeni.com");
        message.addRecipients(Message.RecipientType.CC, "Balderas-F@marubeni.com");
        message.addRecipients(Message.RecipientType.BCC, "alertas@grupocomercialtria.com.mx");

        message.setSubject("Sistema de Cobranza Marubeni");

        message.setContent(multiParte);

        Transport t = session.getTransport("smtp");
        t.connect("alertas@grupocomercialtria.com.mx", "QiVDZ90chqmp");
        t.sendMessage(message, message.getAllRecipients());
        t.close();
    }
}
