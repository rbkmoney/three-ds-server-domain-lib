package com.rbkmoney.threeds.server.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.threeds.server.domain.root.proprietary.PArq;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class SerializerTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void messagesTest() throws IOException {
        PArq pArq = readFromFile("/__files/parq.json", PArq.class);
        String json = writeValueAsString(pArq);
        assertNotNull(json);
        assertTrue(json.contains("\"preOrderDate\":\"20200515\""));
        assertFalse(json.contains("\"value\":"));

        pArq = readFromFile("/__files/parq1.json", PArq.class);
        json = writeValueAsString(pArq);
        assertNotNull(json);
        assertTrue(json.contains("\"preOrderDate\":\"20200623\""));
        assertFalse(json.contains("\"value\":"));
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
}
