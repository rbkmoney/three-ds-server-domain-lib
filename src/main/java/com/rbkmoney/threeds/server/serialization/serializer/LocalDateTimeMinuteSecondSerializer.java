package com.rbkmoney.threeds.server.serialization.serializer;

import java.time.format.DateTimeFormatter;

public class LocalDateTimeMinuteSecondSerializer
        extends com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer {

    public LocalDateTimeMinuteSecondSerializer() {
        super(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }
}
