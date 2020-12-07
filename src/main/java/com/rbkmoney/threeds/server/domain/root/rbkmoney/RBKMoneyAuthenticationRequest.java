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

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
@CustomValidation
public class RBKMoneyAuthenticationRequest extends Message {

    @JsonDeserialize(using = ThreeDsMethodCompletionIndDeserializer.class)
    @JsonSerialize(using = ThreeDsMethodCompletionIndSerializer.class)
    private EnumWrapper<ThreeDsMethodCompletionInd> threeDSCompInd;
    @JsonDeserialize(using = ThreeDSRequestorAuthenticationIndDeserializer.class)
    @JsonSerialize(using = ThreeDSRequestorAuthenticationIndSerializer.class)
    private EnumWrapper<ThreeDSRequestorAuthenticationInd> threeDSRequestorAuthenticationInd;
    private ThreeDSRequestorAuthenticationInfoWrapper threeDSRequestorAuthenticationInfo;
    @JsonDeserialize(using = ThreeDSRequestorChallengeIndDeserializer.class)
    @JsonSerialize(using = ThreeDSRequestorChallengeIndSerializer.class)
    private EnumWrapper<ThreeDSRequestorChallengeInd> threeDSRequestorChallengeInd;
    private String threeDSRequestorDecMaxTime;
    @JsonDeserialize(using = ThreeDSRequestorDecReqIndDeserializer.class)
    @JsonSerialize(using = ThreeDSRequestorDecReqIndSerializer.class)
    private EnumWrapper<ThreeDSRequestorDecReqInd> threeDSRequestorDecReqInd;
    private ThreeDSRequestorPriorAuthenticationInfoWrapper threeDSRequestorPriorAuthenticationInfo;
    private String threeDSServerTransID;
    @JsonDeserialize(using = ThreeRIIndDeserializer.class)
    @JsonSerialize(using = ThreeRIIndSerializer.class)
    private EnumWrapper<ThreeRIInd> threeRIInd;
    @JsonDeserialize(using = AccountTypeDeserializer.class)
    @JsonSerialize(using = AccountTypeSerializer.class)
    private EnumWrapper<AccountType> acctType;
    private String acquirerBIN;
    private String acquirerMerchantID;
    @JsonDeserialize(using = AddressMatchDeserializer.class)
    @JsonSerialize(using = AddressMatchSerializer.class)
    private EnumWrapper<AddressMatch> addrMatch;
    private Object broadInfo;
    private String browserAcceptHeader;
    private String browserIP;
    private Boolean browserJavaEnabled;
    private Boolean browserJavascriptEnabled;
    private String browserLanguage;
    @JsonDeserialize(using = BrowserColorDepthDeserializer.class)
    @JsonSerialize(using = BrowserColorDepthSerializer.class)
    private EnumWrapper<BrowserColorDepth> browserColorDepth;
    private String browserScreenHeight;
    private String browserScreenWidth;
    private String browserTZ;
    private String browserUserAgent;
    private String cardExpiryDate;
    private AccountInfoWrapper acctInfo;
    private String acctNumber;
    private String acctID;
    @JsonUnwrapped(prefix = "bill")
    private Address billingAddress;
    private String email;
    private Phone homePhone;
    private Phone mobilePhone;
    private String cardholderName;
    @JsonUnwrapped(prefix = "ship")
    private Address shippingAddress;
    private Phone workPhone;
    @JsonDeserialize(using = DeviceChannelDeserializer.class)
    @JsonSerialize(using = DeviceChannelSerializer.class)
    private EnumWrapper<DeviceChannel> deviceChannel;
    private Boolean payTokenInd;
    @JsonDeserialize(using = PayTokenSourceDeserializer.class)
    @JsonSerialize(using = PayTokenSourceSerializer.class)
    private EnumWrapper<PayTokenSource> payTokenSource;
    private String purchaseInstalData;
    private String mcc;
    private String merchantCountryCode;
    private String merchantName;
    private MerchantRiskIndicatorWrapper merchantRiskIndicator;
    @JsonDeserialize(using = MessageCategoryDeserializer.class)
    @JsonSerialize(using = MessageCategorySerializer.class)
    private EnumWrapper<MessageCategory> messageCategory;
    @JsonDeserialize(using = MessageExtensionDeserializer.class)
    @JsonSerialize(using = MessageExtensionSerializer.class)
    private ListWrapper<MessageExtension> messageExtension;
    private String notificationURL;
    private String purchaseAmount;
    private String purchaseCurrency;
    private String purchaseExponent;
    @JsonDeserialize(using = LocalDateTimeMinuteSecondWrapperDeserializer.class)
    @JsonSerialize(using = LocalDateTimeMinuteSecondWrapperSerializer.class)
    private TemporalAccessorWrapper<LocalDateTime> purchaseDate;
    @JsonDeserialize(using = LocalDateWrapperDeserializer.class)
    @JsonSerialize(using = LocalDateWrapperSerializer.class)
    private TemporalAccessorWrapper<LocalDate> recurringExpiry;
    private String recurringFrequency;
    @JsonDeserialize(using = TransactionTypeDeserializer.class)
    @JsonSerialize(using = TransactionTypeSerializer.class)
    private EnumWrapper<TransactionType> transType;
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
                ", acquirerBIN='" + acquirerBIN + '\'' +
                ", acquirerMerchantID='" + acquirerMerchantID + '\'' +
                ", email='" + email + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", purchaseAmount='" + purchaseAmount + '\'' +
                ", purchaseCurrency='" + purchaseCurrency + '\'' +
                ", transType=" + transType +
                ", acctID='" + acctID + '\'' +
                ", acctType=" + acctType +
                ", threeDSRequestorAuthenticationInd=" + threeDSRequestorAuthenticationInd +
                ", threeRIInd=" + threeRIInd +
                ", threeDSServerTransID='" + threeDSServerTransID + '\'' +
                ", threeDSCompInd=" + threeDSCompInd +
                '}';
    }
}
