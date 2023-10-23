package com.company.service;

import com.company.dao.WalletDao;
import com.company.entity.Account;
import com.company.entity.Transaction;
import com.company.entity.User;
import com.company.validation.TransactionValidator;

import java.math.BigDecimal;

public class WalletService {

    private WalletDao walletDao;

    public WalletService(){
        this.walletDao = new WalletDao();
    }

    public String createWallet(String name , BigDecimal amount){
        User user = new User(name);
        Account account = new Account(amount,user);
        walletDao.addAccount(account);
        return account.getAccountNumber();
    }

    public void transferAmount(String fromAcc, String toAcc, BigDecimal amount){
        if(!TransactionValidator.validateTransaction(fromAcc,toAcc,amount)){
            return;
        }
        Transaction transaction = new Transaction(fromAcc,toAcc,amount);
        Account fromAccount = walletDao.getAccount(fromAcc);
        Account toAccount = walletDao.getAccount(toAcc);

        if(fromAccount.getBalance().compareTo(amount) < 0){
            System.out.println("Insufficient balance , Transaction failed");
            return;
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));
        fromAccount.addTransaction(transaction);
        toAccount.addTransaction(transaction);
        System.out.println("Transaction success : "+transaction);
    }

    public void statement(String accountNumber){
        Account account = walletDao.getAccount(accountNumber);
        System.out.println("Summary for account number : " + accountNumber);
        System.out.println("Current Balance : "+account.getBalance());
        System.out.println("Your transaction history -----");
        System.out.println(account);
    }

}
