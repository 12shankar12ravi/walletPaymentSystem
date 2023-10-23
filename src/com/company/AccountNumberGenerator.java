package com.company;

import java.util.UUID;

public class AccountNumberGenerator {

    public static String generateAccountNumber(){
        return UUID.randomUUID().toString();
    }
}
