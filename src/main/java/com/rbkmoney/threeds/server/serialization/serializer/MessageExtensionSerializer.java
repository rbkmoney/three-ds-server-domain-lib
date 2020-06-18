package com.rbkmoney.threeds.server.serialization.serializer;

import com.rbkmoney.threeds.server.domain.message.MessageExtension;
import com.rbkmoney.threeds.server.serialization.AbstractListSerializer;

public class MessageExtensionSerializer extends AbstractListSerializer<MessageExtension> {
//
//    @Override
//    protected void serializeValue(MessageExtension value, JsonGenerator jsonGenerator) throws IOException {
//        jsonGenerator.writeStringField("name", value.getName());
//        jsonGenerator.writeStringField("id", value.getId());
//        jsonGenerator.writeBooleanField("criticalityIndicator", value.getCriticalityIndicator());
//
//        jsonGenerator.writeObjectFieldStart("data");
//        for (Map.Entry<String, Object> entry : value.getData().entrySet()) {
//            jsonGenerator.writeObjectField(entry.getKey(), entry.getValue());
//        }
//        jsonGenerator.writeEndObject();
//    }
}
