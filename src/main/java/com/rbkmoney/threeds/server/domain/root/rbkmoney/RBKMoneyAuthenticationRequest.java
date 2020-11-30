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
import com.rbkmoney.threeds.server.utils.AccountNumberUtils;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
@CustomValidation
public class RBKMoneyAuthenticationRequest extends Message {

    private String acctNumber;
    private String cardExpiryDate;
    @JsonDeserialize(using = DeviceChannelDeserializer.class)
    @JsonSerialize(using = DeviceChannelSerializer.class)
    private EnumWrapper<DeviceChannel> deviceChannel;
    @JsonDeserialize(using = MessageCategoryDeserializer.class)
    @JsonSerialize(using = MessageCategorySerializer.class)
    private EnumWrapper<MessageCategory> messageCategory;
    private String threeDSRequestorID;
    private String threeDSRequestorName;
    private String threeDSRequestorURL;
    private String acquirerBIN;
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
    private String email;
    private Phone homePhone;
    private String mcc;
    private String merchantCountryCode;
    private String merchantName;
    private Phone mobilePhone;
    private String purchaseAmount;
    private String purchaseCurrency;
    @JsonDeserialize(using = LocalDateTimeMinuteSecondWrapperDeserializer.class)
    @JsonSerialize(using = LocalDateTimeMinuteSecondWrapperSerializer.class)
    private TemporalAccessorWrapper<LocalDateTime> purchaseDate;
    private String purchaseExponent;
    @JsonDeserialize(using = LocalDateWrapperDeserializer.class)
    @JsonSerialize(using = LocalDateWrapperSerializer.class)
    private TemporalAccessorWrapper<LocalDate> recurringExpiry;
    private String recurringFrequency;
    private String sdkAppID;
    private String sdkEncData;
    private Map<String, String> sdkEphemPubKey;
    private String sdkReferenceNumber;
    private String sdkTransID;
    @JsonUnwrapped(prefix = "ship")
    private Address shippingAddress;
    @JsonDeserialize(using = TransactionTypeDeserializer.class)
    @JsonSerialize(using = TransactionTypeSerializer.class)
    private EnumWrapper<TransactionType> transType;
    private Phone workPhone;
    private String acctID;
    private AccountInfoWrapper acctInfo;
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
    private String threeDSServerRefNumber;
    private String threeDSServerOperatorID;
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

    @Override
    public String toString() {
        return "RBKMoneyAuthenticationRequest{" +
                "super='" + super.toString() + '\'' +
                "acctNumber='" + AccountNumberUtils.hideAccountNumber(acctNumber) + '\'' +
                ", deviceChannel=" + deviceChannel +
                ", messageCategory=" + messageCategory +
                ", threeDSRequestorID='" + threeDSRequestorID + '\'' +
                ", threeDSRequestorName='" + threeDSRequestorName + '\'' +
                ", acquirerBIN='" + acquirerBIN + '\'' +
                ", acquirerMerchantID='" + acquirerMerchantID + '\'' +
                ", email='" + email + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", purchaseAmount='" + purchaseAmount + '\'' +
                ", purchaseCurrency='" + purchaseCurrency + '\'' +
                ", sdkAppID='" + sdkAppID + '\'' +
                ", sdkReferenceNumber='" + sdkReferenceNumber + '\'' +
                ", sdkTransID='" + sdkTransID + '\'' +
                ", transType=" + transType +
                ", acctID='" + acctID + '\'' +
                ", acctType=" + acctType +
                ", threeDSRequestorAuthenticationInd=" + threeDSRequestorAuthenticationInd +
                ", threeRIInd=" + threeRIInd +
                ", threeDSServerRefNumber='" + threeDSServerRefNumber + '\'' +
                ", threeDSServerOperatorID='" + threeDSServerOperatorID + '\'' +
                ", threeDSServerTransID='" + threeDSServerTransID + '\'' +
                ", threeDSCompInd=" + threeDSCompInd +
                '}';
    }
}
