package com.rbkmoney.threeds.server.utils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AccountNumberUtils {

    public static String hideAccountNumber(long accountNumber) {
        return hideAccountNumber(String.valueOf(accountNumber));
    }

    public static String hideAccountNumber(String accountNumber) {
        int length = accountNumber.length();
        if (length > 9) {
            String hidingSymbol = IntStream.range(0, length - 10)
                    .mapToObj(value -> "*")
                    .collect(Collectors.joining());
            return accountNumber.substring(0, 6) + hidingSymbol + accountNumber.substring(length - 4);
        } else {
            return accountNumber;
        }
    }
}
