package com.company.validation;

import java.math.BigDecimal;
import java.util.Objects;

public class TransactionValidator {

    public static boolean validateTransaction(String fromAccNum , String toAccNum , BigDecimal transferAmount){
        if(Objects.equals(fromAccNum, toAccNum)) {
            System.out.println("Sender and Receiver cannot be same.");
            return false;
        }
        if (transferAmount.compareTo(new BigDecimal("0.0001")) < 0) {
            System.out.println("Amount too low");
            return false;
        }
        return true;
    }
}
