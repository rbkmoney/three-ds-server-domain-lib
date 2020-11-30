package com.rbkmoney.threeds.server.domain.cardrange;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rbkmoney.threeds.server.constraint.CustomValidation;
import com.rbkmoney.threeds.server.domain.acs.AcsInfoInd;
import com.rbkmoney.threeds.server.serialization.EnumWrapper;
import com.rbkmoney.threeds.server.serialization.ListWrapper;
import com.rbkmoney.threeds.server.serialization.deserializer.AcsInfoIndDeserializer;
import com.rbkmoney.threeds.server.serialization.deserializer.ActionIndDeserializer;
import com.rbkmoney.threeds.server.serialization.serializer.AcsInfoIndSerializer;
import com.rbkmoney.threeds.server.serialization.serializer.ActionIndSerializer;
import lombok.*;

import static com.rbkmoney.threeds.server.utils.AccountNumberUtils.hideAccountNumber;

/**
 * The Card Range Data data element contains information returned in the PRes message to the 3DS Server from the DS that indicates the most
 * recent EMV 3-D Secure version supported by the ACS that hosts that card range. It also may optionally contain the ACS URL for the 3DS
 * Method if supported by the ACS and the DS Start and End Protocol Versions which support the card range.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
@CustomValidation
public class CardRange {

    private String threeDSMethodURL;
    @JsonDeserialize(using = AcsInfoIndDeserializer.class)
    @JsonSerialize(using = AcsInfoIndSerializer.class)
    private ListWrapper<EnumWrapper<AcsInfoInd>> acsInfoInd;
    private String acsStartProtocolVersion;
    private String acsEndProtocolVersion;
    @JsonDeserialize(using = ActionIndDeserializer.class)
    @JsonSerialize(using = ActionIndSerializer.class)
    private EnumWrapper<ActionInd> actionInd;
    private String dsStartProtocolVersion;
    private String dsEndProtocolVersion;
    @EqualsAndHashCode.Include
    private String startRange;
    @EqualsAndHashCode.Include
    private String endRange;

    @Override
    public String toString() {
        return "CardRange{" +
                "super='" + super.toString() + '\'' +
                ", startRange='" + hideAccountNumber(startRange) + '\'' +
                ", endRange='" + hideAccountNumber(endRange) + '\'' +
                ", actionInd='" + actionInd + '\'' +
                '}';
    }
}
