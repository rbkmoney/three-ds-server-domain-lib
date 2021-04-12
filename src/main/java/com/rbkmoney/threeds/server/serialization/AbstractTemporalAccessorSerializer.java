package com.rbkmoney.threeds.server.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.temporal.TemporalAccessor;

public abstract class AbstractTemporalAccessorSerializer<T extends TemporalAccessor>
        extends JsonSerializer<TemporalAccessorWrapper<T>> {

    protected abstract String format(T value);

    @Override
    public void serialize(
            TemporalAccessorWrapper<T> temporalAccessorWrapper,
            JsonGenerator jsonGenerator,
            SerializerProvider serializers
    ) throws IOException {
        T value = temporalAccessorWrapper.getValue();
        if (value != null) {
            jsonGenerator.writeString(format(value));
        } else {
            serializers.defaultSerializeNull(jsonGenerator);
        }
    }
}
