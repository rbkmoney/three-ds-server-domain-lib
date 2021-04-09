package com.rbkmoney.threeds.server.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rbkmoney.threeds.server.domain.Valuable;

import java.io.IOException;

public abstract class AbstractEnumSerializer<T extends Valuable> extends JsonSerializer<EnumWrapper<T>> {

    @Override
    public void serialize(EnumWrapper<T> enumWrapper, JsonGenerator jsonGenerator, SerializerProvider serializers)
            throws IOException {
        String value = enumWrapper.getValue().getValue();
        if (value != null) {
            jsonGenerator.writeString(value);
        } else {
            serializers.defaultSerializeNull(jsonGenerator);
        }
    }
}
