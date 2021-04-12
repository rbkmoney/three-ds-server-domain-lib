package com.rbkmoney.threeds.server.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.List;

public abstract class AbstractListSerializer<T> extends JsonSerializer<ListWrapper<T>> {

    @Override
    public void serialize(ListWrapper<T> listWrapper, JsonGenerator jsonGenerator, SerializerProvider serializers)
            throws IOException {
        ObjectMapper objectMapper = (ObjectMapper) jsonGenerator.getCodec();

        List<T> values = listWrapper.getValue();
        if (values != null) {
            jsonGenerator.writeStartArray(values.size());
            for (T value : values) {
                if (value != null) {
                    String valueAsString = objectMapper.writeValueAsString(value);
                    jsonGenerator.writeRawValue(valueAsString);
                }
            }
            jsonGenerator.writeEndArray();
        } else {
            serializers.defaultSerializeNull(jsonGenerator);
        }
    }
}
