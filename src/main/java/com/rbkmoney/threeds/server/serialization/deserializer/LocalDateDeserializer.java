package com.rbkmoney.threeds.server.serialization.deserializer;

import java.time.format.DateTimeFormatter;

public class LocalDateDeserializer extends com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer {

    public LocalDateDeserializer() {
        super(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
