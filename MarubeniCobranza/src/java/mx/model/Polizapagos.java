package mx.model;

import java.io.Serializable;

public class Polizapagos implements Serializable {

    private int idVoucher;
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
    private Boolean processed;

    public Polizapagos() {
    }

    public Polizapagos(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public Polizapagos(int idVoucher, String voucherNo, String entryDate, String transactionDate, String currency, String rate, String remarks, String drcr, String unit, String account, String taxCode, String tf, String subAccount, String contractNo, String referenceNo, String dueDate, String amount, String userFolio, String userName, Boolean processed) {
        this.idVoucher = idVoucher;
        this.voucherNo = voucherNo;
        this.entryDate = entryDate;
        this.transactionDate = transactionDate;
        this.currency = currency;
        this.rate = rate;
        this.remarks = remarks;
        this.drcr = drcr;
        this.unit = unit;
        this.account = account;
        this.taxCode = taxCode;
        this.tf = tf;
        this.subAccount = subAccount;
        this.contractNo = contractNo;
        this.referenceNo = referenceNo;
        this.dueDate = dueDate;
        this.amount = amount;
        this.userFolio = userFolio;
        this.userName = userName;
        this.processed = processed;
    }

    public int getIdVoucher() {
        return this.idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
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

    public Boolean getProcessed() {
        return this.processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }
}
