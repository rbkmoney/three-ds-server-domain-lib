package com.rbkmoney.threeds.server.domain.root.rbkmoney;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rbkmoney.threeds.server.constraint.CustomValidation;
import com.rbkmoney.threeds.server.domain.challenge.ChallengeWindowSize;
import com.rbkmoney.threeds.server.domain.root.Message;
import com.rbkmoney.threeds.server.serialization.EnumWrapper;
import com.rbkmoney.threeds.server.serialization.deserializer.ChallengeWindowSizeDeserializer;
import com.rbkmoney.threeds.server.serialization.serializer.ChallengeWindowSizeSerializer;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
@CustomValidation
public class RBKMoneyGetChallengeRequest extends Message {

    @ToString.Include
    private String threeDSServerTransID;
    @ToString.Include
    private String acsTransID;
    @JsonDeserialize(using = ChallengeWindowSizeDeserializer.class)
    @JsonSerialize(using = ChallengeWindowSizeSerializer.class)
    private EnumWrapper<ChallengeWindowSize> challengeWindowSize;

}
