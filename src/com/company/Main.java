package com.company;

import com.company.service.WalletService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        WalletService walletService = new WalletService();
        String account1 = walletService.createWallet("ravi bhatt",new BigDecimal("10.001"));
        String account2 = walletService.createWallet("Ramesh Bhatt",new BigDecimal("5.001"));
        walletService.transferAmount(account1,account2,new BigDecimal("2.1"));
        walletService.transferAmount(account1,account2,new BigDecimal("9.1"));
        walletService.statement(account2);
    }
}
