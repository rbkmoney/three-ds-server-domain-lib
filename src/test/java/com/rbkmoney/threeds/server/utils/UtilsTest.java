package com.rbkmoney.threeds.server.utils;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {

    @Test
    public void name() throws Exception {
        String hideAccountNumber = AccountNumberUtils.hideAccountNumber("111111748574455457462222");
        Assert.assertEquals("111111*2222", hideAccountNumber);
    }
}