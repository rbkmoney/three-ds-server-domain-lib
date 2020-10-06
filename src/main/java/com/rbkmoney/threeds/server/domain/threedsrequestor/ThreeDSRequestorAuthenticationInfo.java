package com.rbkmoney.threeds.server.domain.threedsrequestor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rbkmoney.threeds.server.serialization.deserializer.LocalDateTimeMinuteDeserializer;
import com.rbkmoney.threeds.server.serialization.serializer.LocalDateTimeMinuteSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 3DS Requestor Authentication Information
 * Information about how the 3DS Requestor authenticated the cardholder
 * before or during the transaction.
 * <p>
 * Length: Variable
 * <p>
 * JSON Data Type: Object
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class ThreeDSRequestorAuthenticationInfo {

    private ThreeDSReqAuthMethod threeDSReqAuthMethod;
    @JsonDeserialize(using = LocalDateTimeMinuteDeserializer.class)
    @JsonSerialize(using = LocalDateTimeMinuteSerializer.class)
    private LocalDateTime threeDSReqAuthTimestamp;
    private String threeDSReqAuthData;

}
