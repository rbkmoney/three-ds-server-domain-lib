package com.rbkmoney.threeds.server.domain.root.rbkmoney;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rbkmoney.threeds.server.constraint.CustomValidation;
import com.rbkmoney.threeds.server.domain.account.AccountInfoWrapper;
import com.rbkmoney.threeds.server.domain.account.AccountType;
import com.rbkmoney.threeds.server.domain.address.AddressMatch;
import com.rbkmoney.threeds.server.domain.browser.BrowserColorDepth;
import com.rbkmoney.threeds.server.domain.device.DeviceChannel;
import com.rbkmoney.threeds.server.domain.device.DeviceRenderOptionsWrapper;
import com.rbkmoney.threeds.server.domain.merchant.MerchantRiskIndicatorWrapper;
import com.rbkmoney.threeds.server.domain.message.MessageCategory;
import com.rbkmoney.threeds.server.domain.message.MessageExtension;
import com.rbkmoney.threeds.server.domain.phone.Phone;
import com.rbkmoney.threeds.server.domain.root.Message;
import com.rbkmoney.threeds.server.domain.threedsrequestor.*;
import com.rbkmoney.threeds.server.domain.token.PayTokenSource;
import com.rbkmoney.threeds.server.domain.transaction.TransactionType;
import com.rbkmoney.threeds.server.domain.unwrapped.Address;
import com.rbkmoney.threeds.server.domain.whitelist.WhiteListStatus;
import com.rbkmoney.threeds.server.domain.whitelist.WhiteListStatusSource;
import com.rbkmoney.threeds.server.serialization.EnumWrapper;
import com.rbkmoney.threeds.server.serialization.ListWrapper;
import com.rbkmoney.threeds.server.serialization.TemporalAccessorWrapper;
import com.rbkmoney.threeds.server.serialization.deserializer.*;
import com.rbkmoney.threeds.server.serialization.serializer.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
@CustomValidation
public class RBKMoneyAuthenticationRequest extends Message {

    @ToString.Include
    private String acctNumber;
    private String cardExpiryDate;
    @ToString.Include
    @JsonDeserialize(using = DeviceChannelDeserializer.class)
    @JsonSerialize(using = DeviceChannelSerializer.class)
    private EnumWrapper<DeviceChannel> deviceChannel;
    @ToString.Include
    @JsonDeserialize(using = MessageCategoryDeserializer.class)
    @JsonSerialize(using = MessageCategorySerializer.class)
    private EnumWrapper<MessageCategory> messageCategory;
    private String p_messageVersion;
    @ToString.Include
    private String threeDSRequestorID;
    @ToString.Include
    private String threeDSRequestorName;
    private String threeDSRequestorURL;
    @ToString.Include
    private String acquirerBIN;
    @ToString.Include
    private String acquirerMerchantID;
    @JsonDeserialize(using = AddressMatchDeserializer.class)
    @JsonSerialize(using = AddressMatchSerializer.class)
    private EnumWrapper<AddressMatch> addrMatch;
    @JsonUnwrapped(prefix = "bill")
    private Address billingAddress;
    private String browserAcceptHeader;
    @JsonDeserialize(using = BrowserColorDepthDeserializer.class)
    @JsonSerialize(using = BrowserColorDepthSerializer.class)
    private EnumWrapper<BrowserColorDepth> browserColorDepth;
    private String browserIP;
    private Boolean browserJavaEnabled;
    private String browserLanguage;
    private String browserScreenHeight;
    private String browserScreenWidth;
    private String browserTZ;
    private String browserUserAgent;
    private String cardholderName;
    private DeviceRenderOptionsWrapper deviceRenderOptions;
    @ToString.Include
    private String email;
    private Phone homePhone;
    private String mcc;
    private String merchantCountryCode;
    @ToString.Include
    private String merchantName;
    private Phone mobilePhone;
    @ToString.Include
    private String purchaseAmount;
    @ToString.Include
    private String purchaseCurrency;
    @JsonDeserialize(using = LocalDateTimeMinuteSecondWrapperDeserializer.class)
    @JsonSerialize(using = LocalDateTimeMinuteSecondWrapperSerializer.class)
    private TemporalAccessorWrapper<LocalDateTime> purchaseDate;
    @ToString.Include
    private String purchaseExponent;
    @JsonDeserialize(using = LocalDateWrapperDeserializer.class)
    @JsonSerialize(using = LocalDateWrapperSerializer.class)
    private TemporalAccessorWrapper<LocalDate> recurringExpiry;
    private String recurringFrequency;
    @ToString.Include
    private String sdkAppID;
    private String sdkEncData;
    private Map<String, String> sdkEphemPubKey;
    @ToString.Include
    private String sdkReferenceNumber;
    @ToString.Include
    private String sdkTransID;
    @JsonUnwrapped(prefix = "ship")
    private Address shippingAddress;
    @ToString.Include
    @JsonDeserialize(using = TransactionTypeDeserializer.class)
    @JsonSerialize(using = TransactionTypeSerializer.class)
    private EnumWrapper<TransactionType> transType;
    private Phone workPhone;
    @ToString.Include
    private String acctID;
    private AccountInfoWrapper acctInfo;
    @ToString.Include
    @JsonDeserialize(using = AccountTypeDeserializer.class)
    @JsonSerialize(using = AccountTypeSerializer.class)
    private EnumWrapper<AccountType> acctType;
    private MerchantRiskIndicatorWrapper merchantRiskIndicator;
    @JsonDeserialize(using = MessageExtensionDeserializer.class)
    @JsonSerialize(using = MessageExtensionSerializer.class)
    private ListWrapper<MessageExtension> messageExtension;
    private Boolean payTokenInd;
    private String purchaseInstalData;
    private ThreeDSRequestorAuthenticationInfoWrapper threeDSRequestorAuthenticationInfo;
    @JsonDeserialize(using = ThreeDSRequestorChallengeIndDeserializer.class)
    @JsonSerialize(using = ThreeDSRequestorChallengeIndSerializer.class)
    private EnumWrapper<ThreeDSRequestorChallengeInd> threeDSRequestorChallengeInd;
    @JsonDeserialize(using = ThreeDSRequestorAuthenticationIndDeserializer.class)
    @JsonSerialize(using = ThreeDSRequestorAuthenticationIndSerializer.class)
    private EnumWrapper<ThreeDSRequestorAuthenticationInd> threeDSRequestorAuthenticationInd;
    @JsonDeserialize(using = ThreeRIIndDeserializer.class)
    @JsonSerialize(using = ThreeRIIndSerializer.class)
    private EnumWrapper<ThreeRIInd> threeRIInd;
    private ThreeDSRequestorPriorAuthenticationInfoWrapper threeDSRequestorPriorAuthenticationInfo;
    @ToString.Include
    private String threeDSServerRefNumber;
    @ToString.Include
    private String threeDSServerOperatorID;
    @ToString.Include
    private String threeDSServerTransID;
    private String threeDSServerURL;
    private Object broadInfo;
    private String notificationURL;
    @JsonDeserialize(using = ThreeDsMethodCompletionIndDeserializer.class)
    @JsonSerialize(using = ThreeDsMethodCompletionIndSerializer.class)
    private EnumWrapper<ThreeDsMethodCompletionInd> threeDSCompInd;
    private String sdkMaxTimeout;
    private String acsURL;
    private String threeDSRequestorDecMaxTime;
    @JsonDeserialize(using = ThreeDSRequestorDecReqIndDeserializer.class)
    @JsonSerialize(using = ThreeDSRequestorDecReqIndSerializer.class)
    private EnumWrapper<ThreeDSRequestorDecReqInd> threeDSRequestorDecReqInd;
    private Boolean browserJavascriptEnabled;
    @JsonDeserialize(using = PayTokenSourceDeserializer.class)
    @JsonSerialize(using = PayTokenSourceSerializer.class)
    private EnumWrapper<PayTokenSource> payTokenSource;
    @JsonDeserialize(using = WhiteListStatusDeserializer.class)
    @JsonSerialize(using = WhiteListStatusSerializer.class)
    private EnumWrapper<WhiteListStatus> whiteListStatus;
    @JsonDeserialize(using = WhiteListStatusSourceDeserializer.class)
    @JsonSerialize(using = WhiteListStatusSourceSerializer.class)
    private EnumWrapper<WhiteListStatusSource> whiteListStatusSource;
}
