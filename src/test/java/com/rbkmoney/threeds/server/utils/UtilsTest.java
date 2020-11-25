package com.rbkmoney.threeds.server.utils;

import org.junit.Test;

import static com.rbkmoney.threeds.server.utils.AccountNumberUtils.hideAccountNumber;
import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Test
    public void hideAccountNumberTest() throws Exception {
        String accountNumber = "111111748574455457462222";
        String hideAccountNumber = hideAccountNumber(accountNumber);

        assertEquals(accountNumber.length(), hideAccountNumber.length());
        assertEquals("111111**************2222", hideAccountNumber);

        accountNumber = "1";
        hideAccountNumber = hideAccountNumber(accountNumber);

        assertEquals(accountNumber.length(), hideAccountNumber.length());
        assertEquals("1", hideAccountNumber);

        accountNumber = "1234567890";
        hideAccountNumber = hideAccountNumber(accountNumber);

        assertEquals(accountNumber.length(), hideAccountNumber.length());
        assertEquals("1234567890", hideAccountNumber);

        accountNumber = "12345667890";
        hideAccountNumber = hideAccountNumber(accountNumber);

        assertEquals(accountNumber.length(), hideAccountNumber.length());
        assertEquals("123456*7890", hideAccountNumber);
    }
}