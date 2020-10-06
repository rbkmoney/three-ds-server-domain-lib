package com.rbkmoney.threeds.server.serialization.serializer;

import java.time.format.DateTimeFormatter;

public class LocalDateTimeMinuteSerializer extends com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer {

    public LocalDateTimeMinuteSerializer() {
        super(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
    }
}
