package com.rbkmoney.threeds.server.serialization.serializer;

import java.time.format.DateTimeFormatter;

public class LocalDateSerializer extends com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer {

    public LocalDateSerializer() {
        super(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
