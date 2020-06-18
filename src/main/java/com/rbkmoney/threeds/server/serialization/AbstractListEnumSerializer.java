package com.rbkmoney.threeds.server.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rbkmoney.threeds.server.domain.Valuable;

import java.io.IOException;
import java.util.List;

public abstract class AbstractListEnumSerializer<T extends Valuable> extends JsonSerializer<ListWrapper<EnumWrapper<T>>> {

    @Override
    public void serialize(ListWrapper<EnumWrapper<T>> listWrapper, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        List<EnumWrapper<T>> values = listWrapper.getValue();
        if (values != null) {
            jsonGenerator.writeStartArray(values.size());
            for (EnumWrapper<T> value : values) {
                if (value.getValue().getValue() != null) {
                    jsonGenerator.writeString(value.getValue().getValue());
                }
            }
            jsonGenerator.writeEndArray();
        } else {
            serializers.defaultSerializeNull(jsonGenerator);
        }
    }
}
