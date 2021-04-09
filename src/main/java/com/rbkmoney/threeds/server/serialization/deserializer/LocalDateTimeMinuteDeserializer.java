package com.rbkmoney.threeds.server.serialization.deserializer;

import java.time.format.DateTimeFormatter;

public class LocalDateTimeMinuteDeserializer
        extends com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer {

    public LocalDateTimeMinuteDeserializer() {
        super(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
    }
}
