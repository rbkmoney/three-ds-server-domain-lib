package com.rbkmoney.threeds.server.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.temporal.TemporalAccessor;

@RequiredArgsConstructor
public abstract class AbstractTemporalAccessorDeserializer<T extends TemporalAccessor> extends JsonDeserializer<TemporalAccessorWrapper<T>> {

    protected abstract T parse(String candidate);

    @Override
    public TemporalAccessorWrapper<T> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);

        if (node.isNull()) {
            return null;
        } else if (node.isTextual()) {
            TextNode textNode = (TextNode) node;
            String candidate = textNode.asText();

            try {
                T temporalAccessor = parse(candidate);

                TemporalAccessorWrapper<T> temporalAccessorWrapper = new TemporalAccessorWrapper<>();
                temporalAccessorWrapper.setValue(temporalAccessor);
                return temporalAccessorWrapper;
            } catch (DateTimeException ex) {
                TemporalAccessorWrapper<T> temporalAccessorWrapper = new TemporalAccessorWrapper<>();
                temporalAccessorWrapper.setGarbageValue(candidate);
                return temporalAccessorWrapper;
            }
        } else {
            TemporalAccessorWrapper<T> temporalAccessorWrapper = new TemporalAccessorWrapper<>();
            temporalAccessorWrapper.setGarbageValue(oc.treeToValue(node, Object.class));
            return temporalAccessorWrapper;
        }
    }
}
