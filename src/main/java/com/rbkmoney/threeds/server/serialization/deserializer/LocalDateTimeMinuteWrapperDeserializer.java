package com.rbkmoney.threeds.server.serialization.deserializer;

import com.rbkmoney.threeds.server.serialization.AbstractTemporalAccessorDeserializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeMinuteWrapperDeserializer extends AbstractTemporalAccessorDeserializer<LocalDateTime> {

    @Override
    protected LocalDateTime parse(String candidate) {
        return LocalDateTime.parse(candidate, DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
    }
}
