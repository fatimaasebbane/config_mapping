package org.example.configmapping.test;

public class TransferRequestDto {
    private String sourceAccountId;
    private String destinationAccountId;
    private Double amount;
    private String currency;
    private String reference;
    private String executionDate;
    private String transferType;

    // Getters et setters

    public String getSourceAccountId() {
        return sourceAccountId;
    }
    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }
    public String getDestinationAccountId() {
        return destinationAccountId;
    }
    public void setDestinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public String getExecutionDate() {
        return executionDate;
    }
    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }
    public String getTransferType() {
        return transferType;
    }
    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    @Override
    public String toString() {
        return "TransferRequestDto{" +
                "sourceAccountId='" + sourceAccountId + '\'' +
                ", destinationAccountId='" + destinationAccountId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", reference='" + reference + '\'' +
                ", executionDate='" + executionDate + '\'' +
                ", transferType='" + transferType + '\'' +
                '}';
    }
}
