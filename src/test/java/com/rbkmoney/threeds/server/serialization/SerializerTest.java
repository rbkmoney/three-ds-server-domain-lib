package com.rbkmoney.threeds.server.serialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.threeds.server.domain.root.emvco.AReq;
import com.rbkmoney.threeds.server.domain.root.emvco.ARes;
import com.rbkmoney.threeds.server.domain.root.emvco.PRes;
import com.rbkmoney.threeds.server.domain.root.proprietary.PArq;
import com.rbkmoney.threeds.server.domain.root.proprietary.PArs;
import lombok.Data;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.Assert.*;

public class SerializerTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void messagesEncodedTest() throws IOException {
        assertTrue(readPArq().contains("\"preOrderDate\":\"20300101\""));
        assertFalse(readPArq().contains("\"value\":"));
        assertTrue(readPArq1().contains("\"preOrderDate\":\"20300101\""));
        assertFalse(readPArq1().contains("\"value\":"));
        assertTrue(readPArq2().contains("\"preOrderDate\":\"20300101\""));
        assertFalse(readPArq2().contains("\"value\":"));
        assertTrue(readPArs().contains("\"acsOperatorID\":\"acsOperatorUL\",\"eci\":\"N0\",\"transStatusReason\":\"13\""));
        assertFalse(readPArs().contains("\"value\":"));
        assertTrue(readAReq().contains("\"preOrderDate\":\"20300101\""));
        assertFalse(readAReq().contains("\"value\":"));
        assertTrue(readARes().contains("\"eci\":\"N0\",\"transStatus\":\"U\""));
        assertFalse(readARes().contains("\"value\":"));
    }

    @Test
    public void messagesTest() throws IOException {
        PRes pRes = readFromFile("/__files/pres.json", PRes.class);
        assertNotNull(writeValueAsString(pRes));
        PArq pArq = readFromFile("/__files/parq.json", PArq.class);
        assertNotNull(writeValueAsString(pArq));
        AReq aReq = readFromFile("/__files/areq.json", AReq.class);
        assertNotNull(writeValueAsString(aReq));
    }

    private String readPArq() throws IOException {
        return readMessage("/__files/encoded/parq.json", PArq.class);
    }

    private String readPArq1() throws IOException {
        return readMessage("/__files/encoded/parq1.json", PArq.class);
    }

    private String readPArq2() throws IOException {
        return readMessage("/__files/encoded/parq2.json", PArq.class);
    }

    private String readPArs() throws IOException {
        return readMessage("/__files/encoded/pars.json", PArs.class);
    }

    private String readAReq() throws IOException {
        return readMessage("/__files/encoded/areq.json", AReq.class);
    }

    private String readARes() throws IOException {
        return readMessage("/__files/encoded/ares.json", ARes.class);
    }

    private <T> String readMessage(String fullPath, Class<T> valueType) throws IOException {
        Base64Message base64Message = readFromFile(fullPath, Base64Message.class);
        byte[] src = decodeBody(base64Message);
        T value = readValue(src, valueType);
        return writeValueAsString(value);
    }

    private byte[] decodeBody(Base64Message base64Message) {
        return Base64.getDecoder().decode(base64Message.getBody());
    }

    public <T> T readValue(byte[] src, Class<T> valueType) throws IOException {
        return objectMapper.readValue(src, valueType);
    }

    public <T> T readFromFile(String fullPath, Class<T> valueType) throws IOException {
        return objectMapper.readValue(readStringFromFile(fullPath), valueType);
    }

    public String writeValueAsString(Object value) throws IOException {
        return objectMapper.writeValueAsString(value);
    }

    public String readStringFromFile(String fullPath) throws IOException {
        return IOUtils.toString(
                getClass().getResourceAsStream(fullPath),
                StandardCharsets.UTF_8);
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    public static class Base64Message {

        private String body;

    }
}
