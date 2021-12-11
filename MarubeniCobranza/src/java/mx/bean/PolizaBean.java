package mx.bean;

import java.io.Serializable;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
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
import javax.servlet.http.HttpServletRequest;
import mx.conexion.DAO;

@Named("Poliza")
@ViewScoped
public class PolizaBean extends DAO implements Serializable {

    private String voucherNo;
    private String entryDate;
    private String transactionDate;
    private String currency;
    private String rate;
    private String remarks;
    private String drcr;
    private String unit;
    private String account;
    private String taxCode;
    private String tf;
    private String subAccount;
    private String contractNo;
    private String referenceNo;
    private String dueDate;
    private String amount;
    private String userFolio;
    private String userName;
    private String usrFolio;
    private Date documentDate;
    private String office;
    private String travelerName;
    private String origin;
    private String destination;
    private String purpose;
    private Date departureDate;
    private Date arrivalDate;
    private String status;
    private int day;
    private double advance;
    private String department;
    private String year;
    private double subtotalAvion;
    private double ivaAvion;
    private double totalAvion;
    private String invoice;
    private double subtotalAll;
    private double ivaAll;
    private double importeRetIva;
    private double totalAll;
    private String conceptAll;
    private String uuidAll;
    private String tarjetaAll;
    private String accountAll;
    private String contractAll;
    private String SubAccountAll;
    private String invoiceAll;
    private double ishAll;
    private String var;
    private String var1;
    private String di;
    private String mes;
    private String año;
    private String dia1;
    private String mes1;
    private String año1;
    private String lugarExp;
    private double totalEmp;
    private double totalEmp2;
    private double propinaAll;
    private double asignaAll;
    private double noComprobadoAll;
    private double totalNoComprobadoAll;
    private double TotalTFA;
    private double SubTotalTFA;
    private double IvaTFA;
    private double TotalTFH;
    private double SubTotalTFH;
    private double IvaTFH;
    private String DRCR;
    private String toyo;
    private String tn;
    private double prop;
    private double gas;

    public PolizaBean() {
        this.DRCR = "DR";
    }

    public double getImporteRetIva() {
        return this.importeRetIva;
    }

    public void setImporteRetIva(double importeRetIva) {
        this.importeRetIva = importeRetIva;
    }

    public String getVoucherNo() {
        return this.voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRate() {
        return this.rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDrcr() {
        return this.drcr;
    }

    public void setDrcr(String drcr) {
        this.drcr = drcr;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTaxCode() {
        return this.taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTf() {
        return this.tf;
    }

    public void setTf(String tf) {
        this.tf = tf;
    }

    public String getSubAccount() {
        return this.subAccount;
    }

    public void setSubAccount(String subAccount) {
        this.subAccount = subAccount;
    }

    public String getContractNo() {
        return this.contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getReferenceNo() {
        return this.referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUserFolio() {
        return this.userFolio;
    }

    public void setUserFolio(String userFolio) {
        this.userFolio = userFolio;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getSubtotalAvion() {
        return this.subtotalAvion;
    }

    public void setSubtotalAvion(double subtotalAvion) {
        this.subtotalAvion = subtotalAvion;
    }

    public String getUsrFolio() {
        return this.usrFolio;
    }

    public void setUsrFolio(String usrFolio) {
        this.usrFolio = usrFolio;
    }

    public Date getDocumentDate() {
        return this.documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public String getOffice() {
        return this.office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getTravelerName() {
        return this.travelerName;
    }

    public void setTravelerName(String travelerName) {
        this.travelerName = travelerName;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPurpose() {
        return this.purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Date getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return this.arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getAdvance() {
        return this.advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getImporteAvion() {
        return this.subtotalAvion;
    }

    public void setImporteAvion(double importeAvion) {
        this.subtotalAvion = importeAvion;
    }

    public double getIvaAvion() {
        return this.ivaAvion;
    }

    public void setIvaAvion(double ivaAvion) {
        this.ivaAvion = ivaAvion;
    }

    public double getTotalAvion() {
        return this.totalAvion;
    }

    public void setTotalAvion(double totalAvion) {
        this.totalAvion = totalAvion;
    }

    public String getDi() {
        return this.di;
    }

    public void setDi(String di) {
        this.di = di;
    }

    public String getMes() {
        return this.mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAño() {
        return this.año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getDia1() {
        return this.dia1;
    }

    public void setDia1(String dia1) {
        this.dia1 = dia1;
    }

    public String getMes1() {
        return this.mes1;
    }

    public void setMes1(String mes1) {
        this.mes1 = mes1;
    }

    public String getAño1() {
        return this.año1;
    }

    public void setAño1(String año1) {
        this.año1 = año1;
    }

    public String getVar() {
        return this.var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getVar1() {
        return this.var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getInvoice() {
        return this.invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public double getSubtotalAll() {
        return this.subtotalAll;
    }

    public void setSubtotalAll(double subtotalAll) {
        this.subtotalAll = subtotalAll;
    }

    public double getIvaAll() {
        return this.ivaAll;
    }

    public void setIvaAll(double ivaAll) {
        this.ivaAll = ivaAll;
    }

    public double getTotalAll() {
        return this.totalAll;
    }

    public void setTotalAll(double totalAll) {
        this.totalAll = totalAll;
    }

    public String getConceptAll() {
        return this.conceptAll;
    }

    public void setConceptAll(String conceptAll) {
        this.conceptAll = conceptAll;
    }

    public String getUuidAll() {
        return this.uuidAll;
    }

    public void setUuidAll(String uuidAll) {
        this.uuidAll = uuidAll;
    }

    public String getAccountAll() {
        return this.accountAll;
    }

    public void setAccountAll(String accountAll) {
        this.accountAll = accountAll;
    }

    public String getContractAll() {
        return this.contractAll;
    }

    public void setContractAll(String contractAll) {
        this.contractAll = contractAll;
    }

    public String getSubAccountAll() {
        return this.SubAccountAll;
    }

    public void setSubAccountAll(String SubAccountAll) {
        this.SubAccountAll = SubAccountAll;
    }

    public String getInvoiceAll() {
        return this.invoiceAll;
    }

    public void setInvoiceAll(String invoiceAll) {
        this.invoiceAll = invoiceAll;
    }

    public String getTarjetaAll() {
        return this.tarjetaAll;
    }

    public void setTarjetaAll(String tarjetaAll) {
        this.tarjetaAll = tarjetaAll;
    }

    public double getIshAll() {
        return this.ishAll;
    }

    public void setIshAll(double ishAll) {
        this.ishAll = ishAll;
    }

    public String getLugarExp() {
        return this.lugarExp;
    }

    public void setLugarExp(String lugarExp) {
        this.lugarExp = lugarExp;
    }

    public double getTotalEmp() {
        return this.totalEmp;
    }

    public void setTotalEmp(double totalEmp) {
        this.totalEmp = totalEmp;
    }

    public double getTotalEmp2() {
        return this.totalEmp2;
    }

    public void setTotalEmp2(double totalEmp2) {
        this.totalEmp2 = totalEmp2;
    }

    public double getPropinaAll() {
        return this.propinaAll;
    }

    public void setPropinaAll(double propinaAll) {
        this.propinaAll = propinaAll;
    }

    public double getAsignaAll() {
        return this.asignaAll;
    }

    public void setAsignaAll(double asignaAll) {
        this.asignaAll = asignaAll;
    }

    public double getNoComprobadoAll() {
        return this.noComprobadoAll;
    }

    public void setNoComprobadoAll(double noComprobadoAll) {
        this.noComprobadoAll = noComprobadoAll;
    }

    public double getTotalNoComprobadoAll() {
        return this.totalNoComprobadoAll;
    }

    public void setTotalNoComprobadoAll(double totalNoComprobadoAll) {
        this.totalNoComprobadoAll = totalNoComprobadoAll;
    }

    public double getTotalTFA() {
        return this.TotalTFA;
    }

    public void setTotalTFA(double TotalTFA) {
        this.TotalTFA = TotalTFA;
    }

    public double getSubTotalTFA() {
        return this.SubTotalTFA;
    }

    public void setSubTotalTFA(double SubTotalTFA) {
        this.SubTotalTFA = SubTotalTFA;
    }

    public double getIvaTFA() {
        return this.IvaTFA;
    }

    public void setIvaTFA(double IvaTFA) {
        this.IvaTFA = IvaTFA;
    }

    public double getTotalTFH() {
        return this.TotalTFH;
    }

    public void setTotalTFH(double TotalTFH) {
        this.TotalTFH = TotalTFH;
    }

    public double getSubTotalTFH() {
        return this.SubTotalTFH;
    }

    public void setSubTotalTFH(double SubTotalTFH) {
        this.SubTotalTFH = SubTotalTFH;
    }

    public double getIvaTFH() {
        return this.IvaTFH;
    }

    public void setIvaTFH(double IvaTFH) {
        this.IvaTFH = IvaTFH;
    }

    public String getDRCR() {
        return this.DRCR;
    }

    public void setDRCR(String DRCR) {
        this.DRCR = DRCR;
    }

    public String getToyo() {
        return this.toyo;
    }

    public void setToyo(String toyo) {
        this.toyo = toyo;
    }

    public String getTn() {
        return this.tn;
    }

    public void setTn(String tn) {
        this.tn = tn;
    }

    public double getProp() {
        return this.prop;
    }

    public void setProp(double prop) {
        this.prop = prop;
    }

    public double getGas() {
        return this.gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public void seleccionarViaje() throws ClassNotFoundException, InstantiationException, IllegalAccessException, MessagingException, SQLException {
        try {
            Conectar();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String nombre = request.getParameter("frmGenerar:codigo");
            String folio = request.getParameter("frmGenerar:folio");
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM viaje WHERE status='Cerrar' AND nombreViajero='" + nombre + "' AND folioUsuario='" + folio + "'");
            while (rs.next()) {
                this.usrFolio = rs.getString("folioUsuario");
                this.documentDate = rs.getDate("fechaDocumento");
                this.office = rs.getString("oficina");
                this.travelerName = rs.getString("nombreViajero");
                this.tn = rs.getString("nombreViajero");
                this.origin = rs.getString("origen");
                this.destination = rs.getString("destino");
                this.purpose = rs.getString("proposito");
                this.departureDate = rs.getDate("fechaOrigen");
                this.arrivalDate = rs.getDate("fechaLlegada");
                this.status = rs.getString("status");
                this.day = rs.getInt("dias");
                this.advance = rs.getDouble("totalAsignado");
                this.department = rs.getString("departamento");
                this.year = rs.getString("fechaAno");
                this.var = this.documentDate.toString();
                String[] fecha = this.var.split("-");
                this.año = fecha[0];
                this.mes = fecha[1];
                this.di = fecha[2];
                Date ahora = new Date();
                SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
                this.var1 = formateador.format(ahora);
                String[] mifecha = this.var1.split("-");
                this.dia1 = mifecha[0];
                this.mes1 = mifecha[1];
                this.año1 = mifecha[2];

                AllConcept();
                InsertarGastosGasolina();
                InsertarAnticipo();
                SelectGastosEmp();
                SelectSumaviaticos();
                actualizarEstado();

                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "POLIZA GENERADA EXITOSAMENTE");
                FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "CÓDIGO SAP: " + this.travelerName + " FOLIO USUARIO: " + this.usrFolio);
                FacesContext.getCurrentInstance().addMessage(null, message);
                FacesContext.getCurrentInstance().addMessage(null, message1);
            }

            this.destination = "";
            this.advance = 0.0D;
            this.purpose = "";
            this.department = "";
            this.usrFolio = "";
            this.office = "";
            this.travelerName = "";
            this.origin = "";
            this.destination = "";
            this.purpose = "";
            this.day = 0;
            this.asignaAll = 0.0D;
            this.noComprobadoAll = 0.0D;
            this.totalNoComprobadoAll = 0.0D;
            this.tn = "";
            this.totalEmp = 0.0D;
            this.totalEmp2 = 0.0D;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        Cerrar();
    }

    public void AllConcept() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery("SELECT importe, iva, impuestoRetenido, totalmxn, factura, UPPER(SUBSTRING(uuid,25,12)) AS uuid, nombreConcepto, tarjeta, ish, lugarExpedicion, propina,rfc FROM concepto WHERE folioUsuario='" + this.usrFolio + "' AND nombreUsuario='" + this.travelerName + "'");
            while (rs.next()) {
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.CEILING);
                this.subtotalAll = rs.getDouble("importe");
                this.subtotalAll = new Double(df.format(this.subtotalAll)).doubleValue();
                this.ivaAll = rs.getDouble("iva");
                this.ivaAll = new Double(df.format(this.ivaAll)).doubleValue();
                this.importeRetIva = rs.getDouble("impuestoRetenido");
                this.importeRetIva = new Double(df.format(this.importeRetIva)).doubleValue();
                this.ivaAll -= this.importeRetIva;
                this.totalAll = rs.getDouble("totalmxn");
                this.totalAll = new Double(df.format(this.totalAll)).doubleValue();
                this.invoiceAll = rs.getString("factura");
                this.uuidAll = rs.getString("uuid");

                this.conceptAll = rs.getString("nombreConcepto");
                this.tarjetaAll = rs.getString("tarjeta");
                this.ishAll = rs.getDouble("ish");
                this.lugarExp = rs.getString("lugarExpedicion");
                this.propinaAll = rs.getDouble("propina");
                this.toyo = rs.getString("rfc");
                if (this.ivaAll == 0.0D) {
                    this.ivaAll = (this.totalAll - this.subtotalAll);
                }
                this.TotalTFA = (850 * this.day);
                this.SubTotalTFA = (733 * this.day);
                this.IvaTFA = (117 * this.day);
                this.TotalTFH = (1500 * this.day);
                this.SubTotalTFH = (1293 * this.day);
                this.IvaTFH = (207 * this.day);
                if ((this.conceptAll.equals("Avión")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No"))) {
                    this.accountAll = "32211";
                    this.contractAll = "AVION";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                    this.contractAll = "V0015";
                    this.accountAll = "41210";
                    this.DRCR = "CR";
                    if (this.toyo.equals("VTM8610032J8")) {
                        this.contractAll = this.travelerName;
                        this.travelerName = "V0015";
                    }
                    InsertTotal();
                    this.travelerName = this.tn;
                } else if ((this.conceptAll.equals("Avión")) && (this.uuidAll != null) && (this.tarjetaAll.equals("Si"))) {
                    this.contractAll = "AVION";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                    this.contractAll = "V0015";
                    this.accountAll = "41210";
                    this.DRCR = "CR";
                    if (this.toyo.equals("VTM8610032J8")) {
                        this.contractAll = this.travelerName;
                        this.travelerName = "V0015";
                    }
                    InsertTotal();
                    this.travelerName = this.tn;
                } else if (this.conceptAll.equals("Avión")) {
                    this.contractAll = "Q";
                    this.accountAll = "32272";
                    this.invoiceAll = "AVION";
                    InsertTotal();
                }
                if ((this.conceptAll.equals("Cargos")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No"))) {
                    this.accountAll = "32211";
                    this.contractAll = "CARGOS";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                    this.contractAll = "V0015";
                    this.accountAll = "41210";
                    this.DRCR = "CR";
                    InsertTotal();
                } else if ((this.conceptAll.equals("Cargos")) && (this.uuidAll != null) && (this.tarjetaAll.equals("Si"))) {
                    this.contractAll = "CARGOS";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                    this.contractAll = "V0015";
                    this.accountAll = "41210";
                    this.DRCR = "CR";
                    InsertTotal();
                } else if (this.conceptAll.equals("Cargos")) {
                    this.contractAll = "Q";
                    this.accountAll = "32272";
                    this.invoiceAll = "CARGOS";
                    InsertTotal();
                }
                if ((this.conceptAll.equals("Auto")) && (this.uuidAll != null) && (this.tarjetaAll.equals("Si")) && (this.TotalTFA < 100.0D)) {
                    this.accountAll = "32211";
                    this.contractAll = "RENTA AUTO";
                    this.subtotalAll = this.SubTotalTFA;
                    InsertImporte();
                    this.ivaAll = this.IvaTFA;
                    this.accountAll = "14731";
                    InsertIva();
                    this.contractAll = "TDC";
                    this.accountAll = "44126";
                    this.uuidAll = this.destination;
                    this.totalAll -= this.SubTotalTFA + this.IvaTFA;
                    this.totalAll = new Double(df.format(this.totalAll)).doubleValue();
                    InsertTotal();
                } else if ((this.conceptAll.equals("Auto")) && (this.uuidAll != null) && (this.tarjetaAll.equals("Si")) && (this.TotalTFA > 100.0D)) {
                    this.contractAll = "RENTA AUTO";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                } else if ((this.conceptAll.equals("Auto")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No")) && (this.TotalTFA < 100.0D)) {
                    this.accountAll = "32211";
                    this.contractAll = "RENTA AUTO";
                    this.subtotalAll = this.SubTotalTFA;
                    InsertImporte();
                    this.ivaAll = this.IvaTFA;
                    this.accountAll = "14731";
                    InsertIva();
                    this.contractAll = "RENTA AUTO";
                    this.accountAll = "44126";
                    this.totalAll -= this.SubTotalTFA + this.IvaTFA;
                    this.totalAll = new Double(df.format(this.totalAll)).doubleValue();
                    InsertTotal();
                } else if ((this.conceptAll.equals("Auto")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No")) && (this.TotalTFA > 100.0D)) {
                    this.contractAll = "RENTA AUTO";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                } else if (this.conceptAll.equals("Auto")) {
                    this.contractAll = "Q";
                    this.accountAll = "32272";
                    this.invoiceAll = "RENTA AUTO";
                    InsertTotal();
                }
                if ((this.conceptAll.equals("Caseta")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No"))) {
                    this.contractAll = "CASETAS";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                } else if ((this.conceptAll.equals("Caseta")) && (this.uuidAll != null) && (this.tarjetaAll == null)) {
                    this.contractAll = "CASETAS";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                } else if (this.conceptAll.equals("Caseta")) {
                    this.contractAll = "C";
                    this.accountAll = "32272";
                    this.uuidAll = "CASETAS";
                    InsertTotal();
                }
                if ((this.conceptAll.equals("Gasolina")) && (this.uuidAll != null) && (this.tarjetaAll == null)) {
                    this.contractAll = "GASOLINA";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                } else if ((this.conceptAll.equals("Gasolina")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No"))) {
                    this.contractAll = "GASOLINA";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                } else if (this.conceptAll.equals("Gasolina")) {
                    this.contractAll = "C";
                    this.accountAll = "32272";
                    this.invoiceAll = "GASOLINA";
                    InsertTotal();
                }

                if ((this.conceptAll.equals("Hotel")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No")) && (this.TotalTFH < this.totalAll)) {
                    this.contractAll = "HOTEL";
                    this.accountAll = "32211";
                    this.subtotalAll = this.SubTotalTFH;
                    InsertImporte();
                    this.ivaAll = this.IvaTFH;
                    this.accountAll = "14731";
                    InsertIva();
                    this.contractAll = "HOTEL";
                    this.accountAll = "44126";
                    this.totalAll -= this.SubTotalTFH + this.IvaTFH;
                    InsertTotal();
                } else if ((this.conceptAll.equals("Hotel")) && (this.uuidAll != null) && (this.tarjetaAll.equals("Si")) && (this.TotalTFH < this.totalAll)) {
                    this.contractAll = "HOTEL";
                    this.accountAll = "32211";
                    this.subtotalAll = (this.totalAll - this.ivaAll);
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                    this.contractAll = "HOTEL";
                    this.accountAll = "44126";
                    InsertTotal();
                } else if ((this.conceptAll.equals("Hotel")) && (this.uuidAll != null) && (this.tarjetaAll == null)) {
                    this.contractAll = "HOTEL";
                    this.accountAll = "32211";
                    this.subtotalAll = (this.totalAll - this.ivaAll);
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                } else if ((this.conceptAll.equals("Hotel")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No"))) {
                    this.contractAll = "HOTEL";
                    this.accountAll = "32211";
                    this.subtotalAll = (this.totalAll - this.ivaAll);
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                } else if (this.conceptAll.equals("Hotel")) {
                    this.contractAll = "C";
                    this.accountAll = "32272";
                    this.invoiceAll = "HOTEL";
                    InsertTotal();
                }
                if ((this.conceptAll.equals("Taxi")) && (this.uuidAll != null) && (this.tarjetaAll.equals("Si"))) {
                    this.contractAll = "TAXI";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                    this.contractAll = "TAXI";
                    this.accountAll = "44126";
                    InsertTotal();
                } else if ((this.conceptAll.equals("Taxi")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No"))) {
                    this.contractAll = "TAXI";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                } else if (this.conceptAll.equals("Taxi")) {
                    this.contractAll = "C";
                    this.accountAll = "32272";
                    this.invoiceAll = "TAXI";
                    InsertTotal();
                }

                if ((this.conceptAll.equals("Autobus")) && (this.uuidAll != null) && (this.tarjetaAll.equals("Si"))) {
                    this.contractAll = "AUTOBUS";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                    this.contractAll = "AUTOBUS";
                    this.accountAll = "44126";
                    InsertTotal();
                } else if ((this.conceptAll.equals("Autobus")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No"))) {
                    this.contractAll = "AUTOBUS";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                } else if (this.conceptAll.equals("Autobus")) {
                    this.contractAll = "C";
                    this.accountAll = "32272";
                    this.invoiceAll = "AUTOBUS";
                    InsertTotal();
                }

                if ((this.conceptAll.equals("Tel-Int")) && (this.uuidAll != null) && (this.tarjetaAll.equals("Si"))) {
                    this.contractAll = "TEL-INT";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                    this.contractAll = "TEL-INT";
                    this.accountAll = "44126";
                    InsertTotal();
                } else if ((this.conceptAll.equals("Tel-Int")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No"))) {
                    this.contractAll = "TEL-INT";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                } else if (this.conceptAll.equals("Tel-Int")) {
                    this.contractAll = "C";
                    this.accountAll = "32272";
                    this.invoiceAll = "TEL-INT";
                    InsertTotal();
                }

                if ((this.conceptAll.equals("Mensajería")) && (this.uuidAll != null) && (this.tarjetaAll.equals("Si"))) {
                    this.contractAll = "MENSAJERIA";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                    this.contractAll = "MENSAJERIA";
                    this.accountAll = "44126";
                    InsertTotal();
                } else if ((this.conceptAll.equals("Mensajería")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No"))) {
                    this.contractAll = "MENSAJERIA";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                } else if (this.conceptAll.equals("Mensajería")) {
                    this.contractAll = "C";
                    this.accountAll = "32272";
                    this.invoiceAll = "MENSAJERIA";
                    InsertTotal();
                }

                if ((this.conceptAll.equals("Otros")) && (this.uuidAll != null) && (this.tarjetaAll.equals("Si"))) {
                    this.contractAll = "OTROS";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                    this.contractAll = "OTROS";
                    this.accountAll = "44126";
                    InsertTotal();
                } else if ((this.conceptAll.equals("Otros")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No"))) {
                    this.contractAll = "OTROS";
                    this.accountAll = "32211";
                    InsertImporte();
                    this.accountAll = "14731";
                    InsertIva();
                } else if (this.conceptAll.equals("Otros")) {
                    this.contractAll = "C";
                    this.accountAll = "32272";
                    this.invoiceAll = "OTROS";
                    InsertTotal();
                }
                if ((this.conceptAll.equals("Viáticos")) && (this.uuidAll != null) && (this.tarjetaAll == null)) {
                    this.contractAll = "CONSUMO";
                    this.accountAll = "32234";
                    InsertImporte();
                    if (this.ivaAll != 0.0D) {
                        this.accountAll = "14731";
                        InsertIva();
                    }
                    if (this.propinaAll != 0.0D) {
                        this.contractAll = "B";
                        this.accountAll = "32272";
                        this.uuidAll = "PROPINA";
                        this.totalAll = this.propinaAll;
                        InsertTotal();
                    }
                } else if ((this.conceptAll.equals("Viáticos")) && (this.uuidAll != null) && (this.tarjetaAll.equals("No"))) {
                    this.contractAll = "CONSUMO";
                    this.accountAll = "32234";
                    InsertImporte();
                    if (this.ivaAll != 0.0D) {
                        this.accountAll = "14731";
                        InsertIva();
                    }
                    if (this.propinaAll != 0.0D) {
                        this.contractAll = "B";
                        this.accountAll = "32272";
                        this.uuidAll = "PROPINA";
                        this.totalAll = this.propinaAll;
                        InsertTotal();
                    }
                } else if ((this.conceptAll.equals("Viáticos")) && (this.uuidAll == null)) {
                    this.contractAll = "H";
                    this.accountAll = "32272";
                    this.uuidAll = "CONSUMO";
                    InsertTotal();
                    if (this.propinaAll != 0.0D) {
                        this.contractAll = "B";
                        this.accountAll = "32272";
                        this.uuidAll = "PROPINA";
                        this.totalAll = this.propinaAll;
                        InsertTotal();
                    }
                }

                this.contractAll = "";
                this.accountAll = "";
                this.invoiceAll = "";
                this.uuidAll = "";
                this.tarjetaAll = "";
                this.subAccount = "";
                this.subtotalAll = 0.0D;
                this.ivaAll = 0.0D;
                this.totalAll = 0.0D;
                this.ishAll = 0.0D;
                this.lugarExp = "";
                this.propinaAll = 0.0D;
                this.TotalTFA = 0.0D;
                this.SubTotalTFA = 0.0D;
                this.IvaTFA = 0.0D;
                this.DRCR = "DR";
                this.toyo = "";
                this.prop = 0.0D;
                this.gas = 0.0D;
                this.importeRetIva = 0.0D;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Cerrar();
    }

    public void InsertImporte() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            st.executeUpdate("INSERT INTO poliza (voucherNo, entryDate, transactionDate, currency, rate, remarks, drcr, unit, account, taxCode, tf, subAccount, contractNo, referenceNo, dueDate, amount, userFolio, userName) VALUES ('1','" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.di + "." + this.mes + "." + this.año + "', 'MXN', '', 'GTOS DE VJE " + this.destination + "', '" + this.DRCR + "', '" + this.department + "', '" + this.accountAll + "', '5', '1', '" + this.travelerName + "', '" + this.contractAll + "',  '" + this.uuidAll + "', '" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.subtotalAll + "', '" + this.usrFolio + "', '" + this.tn + "')");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        Cerrar();
    }

    public void InsertIva() {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            st.executeUpdate("INSERT INTO poliza (voucherNo, entryDate, transactionDate, currency, rate, remarks, drcr, unit, account, taxCode, tf, subAccount, contractNo, referenceNo, dueDate, amount, userFolio, userName) VALUES ('1','" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.di + "." + this.mes + "." + this.año + "', 'MXN', '', 'GTOS DE VJE " + this.destination + "', '" + this.DRCR + "', '" + this.department + "', '" + this.accountAll + "', '5', '1', '" + this.travelerName + "', '" + this.contractAll + "',  '" + this.uuidAll + "', '" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.ivaAll + "', '" + this.usrFolio + "', '" + this.tn + "')");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void InsertTotal() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            st.executeUpdate("INSERT INTO poliza (voucherNo, entryDate, transactionDate, currency, rate, remarks, drcr, unit, account, taxCode, tf, subAccount, contractNo, referenceNo, dueDate, amount, userFolio, userName) VALUES ('1','" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.di + "." + this.mes + "." + this.año + "', 'MXN', '', 'GTOS DE VJE " + this.destination + "', '" + this.DRCR + "', '" + this.department + "', '" + this.accountAll + "', '5', '1', '" + this.travelerName + "', '" + this.contractAll + "',  '" + this.uuidAll + "', '" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.totalAll + "', '" + this.usrFolio + "', '" + this.tn + "')");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        Cerrar();
    }

    public void SelectGastosEmp() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(totalmxn) as totalmxn FROM concepto WHERE nombreConcepto<>'Viáticos' AND tarjeta='No'  AND folioUsuario='" + this.usrFolio + "' AND nombreUsuario='" + this.travelerName + "'");
            while (rs.next()) {
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.CEILING);
                this.totalEmp = rs.getDouble("totalmxn");
                SelectAsignacion();
                SelectGastosEmp2();
                this.totalEmp = (this.totalEmp + this.asignaAll + this.totalEmp2 - this.advance);
                this.totalEmp = new Double(df.format(this.totalEmp)).doubleValue();
                InsertGastosEmp();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Cerrar();
    }

    public void SelectGastosEmp2() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(totalmxn) as totalmxn FROM concepto WHERE nombreConcepto<>'Viáticos' AND tarjeta is null AND tarjetaGasolina is null  AND folioUsuario='" + this.usrFolio + "' AND nombreUsuario='" + this.travelerName + "'");
            if (!rs.isBeforeFirst()) {
                this.totalEmp2 = 0.0D;
            } else {
                while (rs.next()) {
                    DecimalFormat df = new DecimalFormat("#.##");
                    df.setRoundingMode(RoundingMode.CEILING);
                    this.totalEmp2 = rs.getDouble("totalmxn");
                    this.totalEmp2 = new Double(df.format(this.totalEmp2)).doubleValue();
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Cerrar();
    }

    public void InsertGastosEmp() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            st.executeUpdate("INSERT INTO poliza (voucherNo, entryDate, transactionDate, currency, rate, remarks, drcr, unit, account, taxCode, tf, subAccount, contractNo, referenceNo, dueDate, amount, userFolio, userName) VALUES ('1','" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.di + "." + this.mes + "." + this.año + "', 'MXN', '', 'GTOS DE VJE " + this.destination + "', 'CR', '" + this.department + "', '44126', '5', '1', '" + this.travelerName + "', 'GASTOS DE VIAJE',  '" + this.destination + "', '" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.totalEmp + "', '" + this.usrFolio + "', '" + this.travelerName + "')");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        Cerrar();
    }

    public void InsertarGastosGasolina() throws SQLException {
        SumaGasolina();
        if (this.gas > 0.0D) {
            try {
                Conectar();
                Statement st = getCn().createStatement();
                st.executeUpdate("INSERT INTO poliza (voucherNo, entryDate, transactionDate, currency, rate, remarks, drcr, unit, account, taxCode, tf, subAccount, contractNo, referenceNo, dueDate, amount, userFolio, userName) VALUES ('1','" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.di + "." + this.mes + "." + this.año + "', 'MXN', '', 'GTOS DE VJE', 'CR', '" + this.department + "', '44126', '5', '1', '" + this.travelerName + "', 'GASOLINA',  '" + this.destination + "', '" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.gas + "', '" + this.usrFolio + "', '" + this.travelerName + "')");
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            Cerrar();
        }
    }

    public void InsertarAnticipo() throws SQLException {
        if (this.advance > 0.0D) {
            try {
                Conectar();
                Statement st = getCn().createStatement();
                st.executeUpdate("INSERT INTO poliza (voucherNo, entryDate, transactionDate, currency, rate, remarks, drcr, unit, account, taxCode, tf, subAccount, contractNo, referenceNo, dueDate, amount, userFolio, userName) VALUES ('1','" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.di + "." + this.mes + "." + this.año + "', 'MXN', '', 'GTOS DE VJE', 'CR', '" + this.department + "', '44126', '5', '1', '" + this.travelerName + "', 'ANTICIPO',  '" + this.destination + "', '" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.advance + "', '" + this.usrFolio + "', '" + this.travelerName + "')");
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void SelectAsignacion() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery("SELECT asignacion  FROM usuario WHERE codigoSap='" + this.travelerName + "'");
            while (rs.next()) {
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.CEILING);
                this.asignaAll = rs.getDouble("asignacion");
                this.noComprobadoAll = rs.getDouble("asignacion");
                this.noComprobadoAll *= this.day;
                this.asignaAll *= this.day;
                this.asignaAll = new Double(df.format(this.asignaAll)).doubleValue();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Cerrar();
    }

    public void SelectSumaviaticos() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery("SELECT sum(totalmxn) as totalmxn  FROM concepto WHERE nombreConcepto='Viáticos' AND folioUsuario='" + this.usrFolio + "' AND nombreUsuario='" + this.travelerName + "'");
            while (rs.next()) {
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.CEILING);
                SumaPropina();
                this.totalNoComprobadoAll = rs.getDouble("totalmxn");
                this.noComprobadoAll -= this.totalNoComprobadoAll + this.prop;

                this.noComprobadoAll = new Double(df.format(this.noComprobadoAll)).doubleValue();
                if (this.noComprobadoAll > 0.0D) {
                    InsertSumaViaticos();
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Cerrar();
    }

    public void SumaPropina() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery("SELECT sum(propina) as propina  FROM concepto WHERE nombreConcepto='Viáticos' AND folioUsuario='" + this.usrFolio + "' AND nombreUsuario='" + this.travelerName + "'");
            if (!rs.isBeforeFirst()) {
                this.prop = 0.0D;
            } else {
                while (rs.next()) {
                    DecimalFormat df = new DecimalFormat("#.##");
                    df.setRoundingMode(RoundingMode.CEILING);
                    this.prop = rs.getDouble("propina");
                    this.prop = new Double(df.format(this.prop)).doubleValue();
                }
            }
        } catch (NumberFormatException | SQLException e) {
            System.err.println(e.getMessage());
        }
        Cerrar();
    }

    public void SumaGasolina() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery("SELECT sum(totalmxn) as totalmxn  FROM concepto WHERE tarjetaGasolina='Si' AND folioUsuario='" + this.usrFolio + "' AND nombreUsuario='" + this.travelerName + "'");
            if (!rs.isBeforeFirst()) {
                this.gas = 0.0D;
            } else {
                while (rs.next()) {
                    DecimalFormat df = new DecimalFormat("#.##");
                    df.setRoundingMode(RoundingMode.CEILING);
                    this.gas = rs.getDouble("totalmxn");
                    this.gas = new Double(df.format(this.gas)).doubleValue();
                }
            }
        } catch (NumberFormatException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void InsertSumaViaticos() throws SQLException {
        try {
            Conectar();
            Statement st = getCn().createStatement();
            st.executeUpdate("INSERT INTO poliza (voucherNo, entryDate, transactionDate, currency, rate, remarks, drcr, unit, account, taxCode, tf, subAccount, contractNo, referenceNo, dueDate, amount, userFolio, userName) VALUES ('1','" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.di + "." + this.mes + "." + this.año + "', 'MXN', '', 'GTOS DE VJE " + this.destination + "', 'DR', '" + this.department + "', '14119', '5', '1', '" + this.travelerName + "', 'VIATICOS',  '" + this.destination + "', '" + this.dia1 + "." + this.mes1 + "." + this.año1 + "','" + this.noComprobadoAll + "', '" + this.usrFolio + "', '" + this.travelerName + "')");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        Cerrar();
    }

    public void actualizarEstado() throws SQLException {
        try {
            Conectar();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String nombre = request.getParameter("frmGenerar:codigo");
            String folio = request.getParameter("frmGenerar:folio");
            PreparedStatement ps = getCn().prepareStatement("UPDATE viaje SET layout=?, status=? WHERE nombreViajero='" + nombre + "' AND folioUsuario='" + folio + "'");
            ps.setString(1, "Si");
            ps.setString(2, "Generada");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Cerrar();
    }

    public void enviarCorreo() throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "p3plcpnl0612.prod.phx3.secureserver.net");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.user", "alertas1@insoftec.com");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(true);

        BodyPart texto = new MimeBodyPart();
        texto.setContent("<html><head><title></title></head><body><table width='678' height='315' border='0' bordercolor='#0000FF' bgcolor='#FFFFFF'><tr><td height='90' colspan='3' bordercolor='#FFFFFF'><br><br><br></td></tr><tr><td colspan='3' bordercolor='#FFFFFF'><p align='left' style='font-family:calibri; font-size:17px'><font color='#17202a'>Se ha generado la siguiente P&oacute;liza: </font><br><br><font color='#17202a'>Clave de Usuario: </font><i><font color='black'> " + this.travelerName + "</font></i> <br><font color='#17202a'>Nombre del Usuario:</font> <font color='black'><i> " + this.travelerName + "</i></font><br><font color='#17202a'>Folio de P&oacute;liza #:</font> <font color='black'><i> " + this.usrFolio + " </i></font><br></td></tr><tr><td width='425' bordercolor='#FFFFFF'><p align='left' style='font-family:calibri; font-size:17px'><br><font color='#17202a'>Sistema de Gastos | </font><font color='#E60013'>Marubeni M&eacute;xico, S.A. de C.V.</font><br><a href='http://etiquetas.marubeni.com.mx:8090/MarubeniMexico/' target='_blank'><img src='cid:image' width='45%'/></a></td><td width='122' bordercolor='#FFFFFF'></td><td width='222' rowspan='2' bordercolor='#FFFFFF'></td></tr><tr><td colspan='2' bordercolor='#17202a'><br><br><p align='center' style='font-family:calibri; font-size:15px'><font color='#17202a'><br> Mensaje enviado desde el Sistema de Gastos Marubeni.</font></p></td></tr></table></body></html>", "text/html");

        MimeMultipart multiParte = new MimeMultipart();
        BodyPart imagen = new MimeBodyPart();
        DataSource fds = new FileDataSource("C:\\img\\marubeni-logo.png");
        imagen.setDataHandler(new DataHandler(fds));
        imagen.setHeader("Content-ID", "<image>");

        multiParte.addBodyPart(texto);

        multiParte.addBodyPart(imagen);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress("alertas1@insoftec.com"));

        message.addRecipient(Message.RecipientType.TO, new InternetAddress("marias@insoftec.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("alertas1@insoftec.com"));

        message.setSubject("Notificación de Póliza, Sistema de Gastos");

        message.setContent(multiParte);

        Transport t = session.getTransport("smtp");
        t.connect("alertas1@insoftec.com", "Pw*Tf+56");
        t.sendMessage(message, message.getAllRecipients());
        t.close();
    }
}
