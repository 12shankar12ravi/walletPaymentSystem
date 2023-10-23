package com.company.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime transactionTime;
    private String senderAccNumber;
    private String receiverAccNumber;
    private BigDecimal amount;

    public Transaction(String senderAccNumber, String receiverAccNumber, BigDecimal amount) {
        this.transactionTime = LocalDateTime.now();
        this.senderAccNumber = senderAccNumber;
        this.receiverAccNumber = receiverAccNumber;
        this.amount = amount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public String getSenderAccNumber() {
        return senderAccNumber;
    }

    public String getReceiverAccNumber() {
        return receiverAccNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionTime=" + transactionTime +
                ", senderAccNumber='" + senderAccNumber + '\'' +
                ", receiverAccNumber='" + receiverAccNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
