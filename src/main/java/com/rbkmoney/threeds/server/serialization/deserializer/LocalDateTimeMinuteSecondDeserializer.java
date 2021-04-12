package com.rbkmoney.threeds.server.serialization.deserializer;

import java.time.format.DateTimeFormatter;

public class LocalDateTimeMinuteSecondDeserializer
        extends com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer {

    public LocalDateTimeMinuteSecondDeserializer() {
        super(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }
}
