package com.rbkmoney.threeds.server.domain.threedsrequestor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rbkmoney.threeds.server.serialization.EnumWrapper;
import com.rbkmoney.threeds.server.serialization.TemporalAccessorWrapper;
import com.rbkmoney.threeds.server.serialization.deserializer.LocalDateTimeMinuteWrapperDeserializer;
import com.rbkmoney.threeds.server.serialization.deserializer.ThreeDSReqAuthMethodDeserializer;
import com.rbkmoney.threeds.server.serialization.serializer.LocalDateTimeMinuteWrapperSerializer;
import com.rbkmoney.threeds.server.serialization.serializer.ThreeDSReqAuthMethodSerializer;
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
public class ThreeDSRequestorAuthenticationInfoWrapper {

    @JsonDeserialize(using = ThreeDSReqAuthMethodDeserializer.class)
    @JsonSerialize(using = ThreeDSReqAuthMethodSerializer.class)
    private EnumWrapper<ThreeDSReqAuthMethod> threeDSReqAuthMethod;
    @JsonDeserialize(using = LocalDateTimeMinuteWrapperDeserializer.class)
    @JsonSerialize(using = LocalDateTimeMinuteWrapperSerializer.class)
    private TemporalAccessorWrapper<LocalDateTime> threeDSReqAuthTimestamp;
    private String threeDSReqAuthData;

}
