package com.rbkmoney.threeds.server.domain.root.emvco;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rbkmoney.threeds.server.constraint.CustomValidation;
import com.rbkmoney.threeds.server.domain.acs.AcsRenderingTypeWrapper;
import com.rbkmoney.threeds.server.domain.authentication.AuthenticationMethod;
import com.rbkmoney.threeds.server.domain.authentication.AuthenticationType;
import com.rbkmoney.threeds.server.domain.challenge.ChallengeCancel;
import com.rbkmoney.threeds.server.domain.message.MessageCategory;
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
public class RReq extends Message {

    @ToString.Include
    private String threeDSServerTransID;
    @ToString.Include
    private String acsTransID;
    private AcsRenderingTypeWrapper acsRenderingType;
    @JsonDeserialize(using = AuthenticationMethodDeserializer.class)
    @JsonSerialize(using = AuthenticationMethodSerializer.class)
    private EnumWrapper<AuthenticationMethod> authenticationMethod;
    @ToString.Include
    @JsonDeserialize(using = AuthenticationTypeDeserializer.class)
    @JsonSerialize(using = AuthenticationTypeSerializer.class)
    private EnumWrapper<AuthenticationType> authenticationType;
    private String authenticationValue;
    @ToString.Include
    @JsonDeserialize(using = ChallengeCancelDeserializer.class)
    @JsonSerialize(using = ChallengeCancelSerializer.class)
    private EnumWrapper<ChallengeCancel> challengeCancel;
    @ToString.Include
    private String dsTransID;
    private String eci;
    private String interactionCounter;
    @ToString.Include
    @JsonDeserialize(using = MessageCategoryDeserializer.class)
    @JsonSerialize(using = MessageCategorySerializer.class)
    private EnumWrapper<MessageCategory> messageCategory;
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
    @JsonDeserialize(using = WhiteListStatusDeserializer.class)
    @JsonSerialize(using = WhiteListStatusSerializer.class)
    private EnumWrapper<WhiteListStatus> whiteListStatus;
    @JsonDeserialize(using = WhiteListStatusSourceDeserializer.class)
    @JsonSerialize(using = WhiteListStatusSourceSerializer.class)
    private EnumWrapper<WhiteListStatusSource> whiteListStatusSource;

}
