package org.example.configmapping.test;



public class SopraTransferRequest {
    private String debitAccount;
    private String creditAccount;
    private Double transactionAmount;
    private String transactionCurrency;
    private String referenceNumber;
    private String requestedExecutionDate;
    private String operationType;

    // Getters et setters

    public String getDebitAccount() {
        return debitAccount;
    }
    public void setDebitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
    }
    public String getCreditAccount() {
        return creditAccount;
    }
    public void setCreditAccount(String creditAccount) {
        this.creditAccount = creditAccount;
    }
    public Double getTransactionAmount() {
        return transactionAmount;
    }
    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    public String getTransactionCurrency() {
        return transactionCurrency;
    }
    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }
    public String getReferenceNumber() {
        return referenceNumber;
    }
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
    public String getRequestedExecutionDate() {
        return requestedExecutionDate;
    }
    public void setRequestedExecutionDate(String requestedExecutionDate) {
        this.requestedExecutionDate = requestedExecutionDate;
    }
    public String getOperationType() {
        return operationType;
    }
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        return "SopraTransferRequest{" +
                "debitAccount='" + debitAccount + '\'' +
                ", creditAccount='" + creditAccount + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", transactionCurrency='" + transactionCurrency + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", requestedExecutionDate='" + requestedExecutionDate + '\'' +
                ", operationType='" + operationType + '\'' +
                '}';
    }
}
