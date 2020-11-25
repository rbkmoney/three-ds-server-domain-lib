package com.rbkmoney.threeds.server.utils;

import org.junit.Test;

import static com.rbkmoney.threeds.server.utils.AccountNumberUtils.hideAccountNumber;
import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Test
    public void hideAccountNumberTest() throws Exception {
        String hideAccountNumber = hideAccountNumber("111111748574455457462222");
        assertEquals("111111*2222", hideAccountNumber);
    }
}