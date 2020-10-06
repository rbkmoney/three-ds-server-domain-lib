package com.rbkmoney.threeds.server.serialization.deserializer;

import com.rbkmoney.threeds.server.serialization.AbstractTemporalAccessorDeserializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateWrapperDeserializer extends AbstractTemporalAccessorDeserializer<LocalDate> {

    @Override
    protected LocalDate parse(String candidate) {
        return LocalDate.parse(candidate, DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
