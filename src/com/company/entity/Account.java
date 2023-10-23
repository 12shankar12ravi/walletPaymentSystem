package com.company.entity;

import com.company.AccountNumberGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Account {
    private User user;
    private BigDecimal balance;
    private String accountNumber;
    private LocalDateTime creationDate;
    private Set<Transaction> transactionHistory;

    public Account(BigDecimal balance,User user) {
        this.balance = balance;
        this.user = user;
        this.accountNumber = AccountNumberGenerator.generateAccountNumber();
        this.creationDate = LocalDateTime.now();
        this.transactionHistory = new TreeSet<>(Comparator.comparing(Transaction::getTransactionTime));
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void addTransaction(Transaction transaction){
        transactionHistory.add(transaction);
    }

    @Override
    public String toString() {
        return "Account{" +
                "user=" + user +
                ", balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", creationDate=" + creationDate +
                ", transactionHistory=" + transactionHistory +
                '}';
    }
}
