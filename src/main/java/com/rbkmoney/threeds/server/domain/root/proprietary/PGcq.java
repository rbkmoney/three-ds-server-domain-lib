package com.rbkmoney.threeds.server.domain.root.proprietary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rbkmoney.threeds.server.constraint.CustomValidation;
import com.rbkmoney.threeds.server.domain.ChallengeWindowSize;
import com.rbkmoney.threeds.server.domain.root.Message;
import com.rbkmoney.threeds.server.serialization.EnumWrapper;
import com.rbkmoney.threeds.server.serialization.deserializer.ChallengeWindowSizeDeserializer;
import lombok.*;

/**
 * proprietary Get Challenge Request
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
@CustomValidation
public class PGcq extends Message {

    private String p_messageVersion;
    private String threeDSServerTransID;
    private String acsTransID;
    private String threeDSSessionData;
    @JsonDeserialize(using = ChallengeWindowSizeDeserializer.class)
    private EnumWrapper<ChallengeWindowSize> challengeWindowSize;

}
