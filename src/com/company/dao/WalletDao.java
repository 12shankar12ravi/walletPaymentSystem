package com.company.dao;

import com.company.entity.Account;

import java.util.HashMap;
import java.util.Map;

public class WalletDao {
    private Map<String, Account> accountMap;

    public WalletDao() {
        accountMap = new HashMap<>();
    }

    public Account getAccount(String accountNumber){
        if(accountMap.containsKey(accountNumber)){
            return accountMap.get(accountNumber);
        }
        throw new RuntimeException("Account number does not exist");
    }

    public void addAccount(Account account){
        accountMap.put(account.getAccountNumber(),account);
    }
}
