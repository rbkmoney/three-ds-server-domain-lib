package com.rbkmoney.threeds.server.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.rbkmoney.threeds.server.domain.account.AccountType;
import com.rbkmoney.threeds.server.domain.acs.AcsInfoInd;
import com.rbkmoney.threeds.server.domain.cardrange.CardRange;
import com.rbkmoney.threeds.server.domain.message.MessageExtension;
import com.rbkmoney.threeds.server.serialization.deserializer.*;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DeserializerTest {

    private static final String ACTUAL_GARBAGE_VALUE = "KEKW";

    @Test
    public void enumWrapperWithItemSerializerTest() throws IOException {
        AccountType actual = AccountType.DEBIT;

        ObjectMapper mapper = configMapperWithItemSerializer();

        Item item = createItem(actual);

        String serialized = mapper.writeValueAsString(item);
        AccountType accountType = mapper.readValue(serialized, Item.class).getAcctType().getValue();
        assertEquals(actual, accountType);
    }

    @Test
    public void enumWrapperTest() throws IOException {
        String actualValue = "03";

        ObjectMapper mapper = new ObjectMapper();

        Object value = mapper.readValue("{\"acctType\":\"" + actualValue + "\"}", Item.class).getAcctType().getValue().getValue();
        assertEquals(actualValue, value);
    }

    @Test
    public void enumWrapperGarbageTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Object value = mapper.readValue("{\"acctType\":\"" + ACTUAL_GARBAGE_VALUE + "\"}", Item.class).getAcctType().getGarbageValue();
        assertEquals(ACTUAL_GARBAGE_VALUE, value);
    }

    @Test
    public void listWrapperTest() throws IOException {
        String actualEndRange = "6543200199999";

        ObjectMapper mapper = new ObjectMapper();

        CardRange cardRange = mapper.readValue("{\n" +
                        "    \"cardRangeData\": [\n" +
                        "        {\n" +
                        "            \"startRange\": \"6543200100000\",\n" +
                        "            \"endRange\": \"" + actualEndRange + "\",\n" +
                        "            \"acsStartProtocolVersion\": \"2.1.0\",\n" +
                        "            \"acsEndProtocolVersion\": \"2.1.0\",\n" +
                        "            \"threeDSMethodURL\": \"https://simulator-3ds.selftestplatform.com/v2.1.0/ds/813/3dsMethod\",\n" +
                        "            \"dsStartProtocolVersion\": \"2.1.0\",\n" +
                        "            \"dsEndProtocolVersion\": \"2.2.0\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"startRange\": \"65432102000000\",\n" +
                        "            \"endRange\": \"65432102999999\",\n" +
                        "            \"acsStartProtocolVersion\": \"2.1.0\",\n" +
                        "            \"acsEndProtocolVersion\": \"2.1.0\",\n" +
                        "            \"threeDSMethodURL\": \"https://simulator-3ds.selftestplatform.com/v2.1.0/ds/813/3dsMethod\",\n" +
                        "            \"dsStartProtocolVersion\": \"2.1.0\",\n" +
                        "            \"dsEndProtocolVersion\": \"2.2.0\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}",
                Item.class
        )
                .getCardRangeData()
                .getValue()
                .get(0);

        assertEquals(actualEndRange, cardRange.getEndRange());
    }

    @Test
    public void listWrapperGarbageTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Object value = mapper.readValue("{\"cardRangeData\":\"" + ACTUAL_GARBAGE_VALUE + "\"}", Item.class).getCardRangeData().getGarbageValue();
        assertEquals(ACTUAL_GARBAGE_VALUE, value);
    }

    @Test
    public void listEnumWrapperTest() throws IOException {
        String actual = "01";

        ObjectMapper mapper = new ObjectMapper();

        AcsInfoInd acsInfoInd = mapper.readValue("{\n" +
                        "                                \"acsInfoInd\": [\n" +
                        "                                    \"" + actual + "\",\n" +
                        "                                    \"02\",\n" +
                        "                                    \"03\",\n" +
                        "                                    \"04\"\n" +
                        "                                ]\n" +
                        "                            }",
                Item.class
        )
                .getAcsInfoInd()
                .getValue()
                .get(0)
                .getValue();

        assertEquals(actual, acsInfoInd.getValue());
    }

    @Test
    public void listEnumWrapperGarbageTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Object value = mapper.readValue("{\"acsInfoInd\":\"" + ACTUAL_GARBAGE_VALUE + "\"}", Item.class).getAcsInfoInd().getGarbageValue();
        assertEquals(ACTUAL_GARBAGE_VALUE, value);
    }

    @Test
    public void temporalAccessorWrapperTest() throws IOException {
        String actualValue = "20170101";

        ObjectMapper mapper = new ObjectMapper();

        Object value = mapper.readValue("{\"chAccChange\": \"" + actualValue + "\"}", Item.class).getChAccChange().getValue().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        assertEquals(actualValue, value);
    }

    @Test
    public void temporalAccessorWrapperGarbageTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Object value = mapper.readValue("{\"chAccChange\":\"" + ACTUAL_GARBAGE_VALUE + "\"}", Item.class).getChAccChange().getGarbageValue();
        assertEquals(ACTUAL_GARBAGE_VALUE, value);
    }

    @Test
    public void messageExtensionDeserializeTest() throws IOException {
        String actualTotalScore = "-200";
        String actualScore = "-300";

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> data = mapper.readValue("{\n" +
                        "    \"messageExtension\": [\n" +
                        "        {\n" +
                        "            \"criticalityIndicator\": false,\n" +
                        "            \"id\": \"A00000065801\",\n" +
                        "            \"name\": \"rbaScoring\",\n" +
                        "            \"data\": {\n" +
                        "                \"totalScore\":" + actualTotalScore + ",\n" +
                        "                \"ruleSets\": [\n" +
                        "                    {\n" +
                        "                        \"ruleSetId\": 2001,\n" +
                        "                        \"score\": " + actualScore + ",\n" +
                        "                        \"description\": \"Test Score\"\n" +
                        "                    }\n" +
                        "                ]\n" +
                        "            }\n" +
                        "        }\n" +
                        "    ]}",
                Item.class
        )
                .getMessageExtension()
                .getValue()
                .get(0)
                .getData();

        assertEquals(actualTotalScore, String.valueOf(data.get("totalScore")));
        assertEquals(actualScore, String.valueOf(((List<Map<String, Object>>) data.get("ruleSets")).get(0).get("score")));

        String value = "value";
        data = mapper.readValue("{" +
                        "\"messageExtension\": [\n" +
                        "                            {\n" +
                        "                                \"name\": \"testExtensionNonCriticalField\",\n" +
                        "                                \"id\": \"ID3\",\n" +
                        "                                \"criticalityIndicator\": false,\n" +
                        "                                \"data\": {\n" +
                        "                                    \"valueOne\": \"" + value + "\"\n" +
                        "                                }\n" +
                        "                            }\n" +
                        "                        ]" +
                        "}",
                Item.class
        )
                .getMessageExtension()
                .getValue()
                .get(0)
                .getData();

        assertEquals(value, String.valueOf(data.get("valueOne")));
    }

    private Item createItem(AccountType actual) {
        EnumWrapper<AccountType> acctType = new EnumWrapper<>();
        acctType.setValue(actual);
        Item item = new Item();
        item.setAcctType(acctType);
        return item;
    }

    private ObjectMapper configMapperWithItemSerializer() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Item.class, new ItemSerializer());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);
        return mapper;
    }

    public static class ItemSerializer extends JsonSerializer<Item> {
        @Override
        public void serialize(Item value, JsonGenerator jgen, SerializerProvider serializers) throws IOException {
            jgen.writeStartObject();
            jgen.writeStringField("acctType", value.getAcctType().getValue().getValue());
            jgen.writeEndObject();
        }
    }

    @Getter
    @Setter
    public static class Item {

        @JsonDeserialize(using = AccountTypeDeserializer.class)
        private EnumWrapper<AccountType> acctType;
        @JsonDeserialize(using = CardRangeDataDeserializer.class)
        private ListWrapper<CardRange> cardRangeData;
        @JsonDeserialize(using = AcsInfoIndDeserializer.class)
        private ListWrapper<EnumWrapper<AcsInfoInd>> acsInfoInd;
        @JsonDeserialize(using = LocalDateWrapperDeserializer.class)
        private TemporalAccessorWrapper<LocalDate> chAccChange;
        @JsonDeserialize(using = MessageExtensionDeserializer.class)
        private ListWrapper<MessageExtension> messageExtension;

    }
}
