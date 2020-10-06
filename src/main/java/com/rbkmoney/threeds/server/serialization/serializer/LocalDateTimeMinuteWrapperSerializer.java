package com.rbkmoney.threeds.server.serialization.serializer;

import com.rbkmoney.threeds.server.serialization.AbstractTemporalAccessorSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeMinuteWrapperSerializer extends AbstractTemporalAccessorSerializer<LocalDateTime> {

    @Override
    protected String format(LocalDateTime value) {
        return value.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
    }
}
