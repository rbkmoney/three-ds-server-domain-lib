package com.rbkmoney.threeds.server.serialization.serializer;

import com.rbkmoney.threeds.server.serialization.AbstractTemporalAccessorSerializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateWrapperSerializer extends AbstractTemporalAccessorSerializer<LocalDate> {

    @Override
    protected String format(LocalDate value) {
        return value.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
