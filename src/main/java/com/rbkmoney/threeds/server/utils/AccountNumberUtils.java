package com.rbkmoney.threeds.server.utils;

public class AccountNumberUtils {

    public static String hideAccountNumber(long accountNumber) {
        return hideAccountNumber(String.valueOf(accountNumber));
    }

    public static String hideAccountNumber(String accountNumber) {
        if (accountNumber.length() > 6) {
            return accountNumber.substring(0, 6) + "*" + accountNumber.substring(accountNumber.length() - 4);
        } else {
            return accountNumber;
        }
    }
}
