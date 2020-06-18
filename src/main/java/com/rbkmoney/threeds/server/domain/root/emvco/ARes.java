package com.rbkmoney.threeds.server.domain.root.emvco;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rbkmoney.threeds.server.constraint.CustomValidation;
import com.rbkmoney.threeds.server.domain.acs.AcsChallengeMandated;
import com.rbkmoney.threeds.server.domain.acs.AcsDecConInd;
import com.rbkmoney.threeds.server.domain.acs.AcsRenderingTypeWrapper;
import com.rbkmoney.threeds.server.domain.authentication.AuthenticationType;
import com.rbkmoney.threeds.server.domain.message.MessageExtension;
import com.rbkmoney.threeds.server.domain.root.Message;
import com.rbkmoney.threeds.server.domain.transaction.TransactionStatus;
import com.rbkmoney.threeds.server.domain.transaction.TransactionStatusReason;
import com.rbkmoney.threeds.server.domain.whitelist.WhiteListStatus;
import com.rbkmoney.threeds.server.domain.whitelist.WhiteListStatusSource;
import com.rbkmoney.threeds.server.serialization.EnumWrapper;
import com.rbkmoney.threeds.server.serialization.ListWrapper;
import com.rbkmoney.threeds.server.serialization.deserializer.*;
import com.rbkmoney.threeds.server.serialization.serializer.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
@CustomValidation
public class ARes extends Message {

    @ToString.Include
    private String threeDSServerTransID;
    @ToString.Include
    @JsonDeserialize(using = AcsChallengeMandatedDeserializer.class)
    @JsonSerialize(using = AcsChallengeMandatedSerializer.class)
    private EnumWrapper<AcsChallengeMandated> acsChallengeMandated;
    @ToString.Include
    @JsonDeserialize(using = AcsDecConIndDeserializer.class)
    @JsonSerialize(using = AcsDecConIndSerializer.class)
    private EnumWrapper<AcsDecConInd> acsDecConInd;
    private String acsOperatorID;
    private String acsReferenceNumber;
    private AcsRenderingTypeWrapper acsRenderingType;
    private String acsSignedContent;
    @ToString.Include
    private String acsTransID;
    private String acsURL;
    @ToString.Include
    @JsonDeserialize(using = AuthenticationTypeDeserializer.class)
    @JsonSerialize(using = AuthenticationTypeSerializer.class)
    private EnumWrapper<AuthenticationType> authenticationType;
    private String authenticationValue;
    private Object broadInfo;
    private String cardholderInfo;
    private String dsReferenceNumber;
    @ToString.Include
    private String dsTransID;
    private String eci;
    @JsonDeserialize(using = MessageExtensionDeserializer.class)
    @JsonSerialize(using = MessageExtensionSerializer.class)
    private ListWrapper<MessageExtension> messageExtension;
    @ToString.Include
    private String sdkTransID;
    @ToString.Include
    @JsonDeserialize(using = TransactionStatusDeserializer.class)
    @JsonSerialize(using = TransactionStatusSerializer.class)
    private EnumWrapper<TransactionStatus> transStatus;
    @ToString.Include
    @JsonDeserialize(using = TransactionStatusReasonDeserializer.class)
    @JsonSerialize(using = TransactionStatusReasonSerializer.class)
    private EnumWrapper<TransactionStatusReason> transStatusReason;
    @ToString.Include
    @JsonDeserialize(using = WhiteListStatusDeserializer.class)
    @JsonSerialize(using = WhiteListStatusSerializer.class)
    private EnumWrapper<WhiteListStatus> whiteListStatus;
    @ToString.Include
    @JsonDeserialize(using = WhiteListStatusSourceDeserializer.class)
    @JsonSerialize(using = WhiteListStatusSourceSerializer.class)
    private EnumWrapper<WhiteListStatusSource> whiteListStatusSource;

}
