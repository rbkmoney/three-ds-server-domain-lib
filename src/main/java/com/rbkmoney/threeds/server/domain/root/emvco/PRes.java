package com.rbkmoney.threeds.server.domain.root.emvco;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rbkmoney.threeds.server.constraint.CustomValidation;
import com.rbkmoney.threeds.server.domain.cardrange.CardRange;
import com.rbkmoney.threeds.server.domain.message.MessageExtension;
import com.rbkmoney.threeds.server.domain.root.Message;
import com.rbkmoney.threeds.server.serialization.ListWrapper;
import com.rbkmoney.threeds.server.serialization.deserializer.MessageExtensionDeserializer;
import com.rbkmoney.threeds.server.serialization.serializer.MessageExtensionSerializer;
import lombok.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
@CustomValidation
public class PRes extends Message {

    private String threeDSServerTransID;
    // todo
    //    @JsonDeserialize(using = CardRangeDataDeserializer.class)
    //    @JsonSerialize(using = CardRangeDataSerializer.class)
    private List<CardRange> cardRangeData;
    private String dsEndProtocolVersion;
    private String dsStartProtocolVersion;
    private String dsTransID;
    @JsonDeserialize(using = MessageExtensionDeserializer.class)
    @JsonSerialize(using = MessageExtensionSerializer.class)
    private ListWrapper<MessageExtension> messageExtension;
    private String serialNum;

    private boolean handleRepetitionNeeded = false;

    @Override
    public String toString() {
        return "PRes{" +
                "super='" + super.toString() + '\'' +
                ", threeDSServerTransID='" + threeDSServerTransID + '\'' +
                ", dsTransID='" + dsTransID + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", cardRangeData='" + Optional.ofNullable(cardRangeData).map(List::size).orElse(null) + '\'' +
                '}';
    }
}
