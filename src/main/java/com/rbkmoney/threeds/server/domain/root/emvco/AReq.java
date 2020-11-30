package com.rbkmoney.threeds.server.domain.root.emvco;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rbkmoney.threeds.server.domain.account.AccountInfo;
import com.rbkmoney.threeds.server.domain.account.AccountType;
import com.rbkmoney.threeds.server.domain.address.AddressMatch;
import com.rbkmoney.threeds.server.domain.browser.BrowserColorDepth;
import com.rbkmoney.threeds.server.domain.device.DeviceChannel;
import com.rbkmoney.threeds.server.domain.device.DeviceRenderOptions;
import com.rbkmoney.threeds.server.domain.merchant.MerchantRiskIndicator;
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
import com.rbkmoney.threeds.server.serialization.deserializer.LocalDateDeserializer;
import com.rbkmoney.threeds.server.serialization.deserializer.LocalDateTimeMinuteSecondDeserializer;
import com.rbkmoney.threeds.server.serialization.serializer.LocalDateSerializer;
import com.rbkmoney.threeds.server.serialization.serializer.LocalDateTimeMinuteSecondSerializer;
import com.rbkmoney.threeds.server.utils.AccountNumberUtils;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class AReq extends Message {

    private ThreeDsMethodCompletionInd threeDSCompInd;
    private ThreeDSRequestorAuthenticationInd threeDSRequestorAuthenticationInd;
    private ThreeDSRequestorAuthenticationInfo threeDSRequestorAuthenticationInfo;
    private ThreeDSReqAuthMethodInd threeDSReqAuthMethodInd;
    private ThreeDSRequestorChallengeInd threeDSRequestorChallengeInd;
    private String threeDSRequestorDecMaxTime;
    private ThreeDSRequestorDecReqInd threeDSRequestorDecReqInd;
    private String threeDSRequestorID;
    private String threeDSRequestorName;
    private ThreeDSRequestorPriorAuthenticationInfo threeDSRequestorPriorAuthenticationInfo;
    private String threeDSRequestorURL;
    private String threeDSServerRefNumber;
    private String threeDSServerOperatorID;
    private String threeDSServerTransID;
    private String threeDSServerURL;
    private ThreeRIInd threeRIInd;
    private AccountType acctType;
    private String acquirerBIN;
    private String acquirerMerchantID;
    private AddressMatch addrMatch;
    private Object broadInfo;
    private String browserAcceptHeader;
    private String browserIP;
    private Boolean browserJavaEnabled;
    private Boolean browserJavascriptEnabled;
    private String browserLanguage;
    private BrowserColorDepth browserColorDepth;
    private String browserScreenHeight;
    private String browserScreenWidth;
    private String browserTZ;
    private String browserUserAgent;
    private String cardExpiryDate;
    private AccountInfo acctInfo;
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
    private DeviceChannel deviceChannel;
    private String deviceInfo;
    private DeviceRenderOptions deviceRenderOptions;
    private String dsReferenceNumber;
    private String dsTransID;
    private String dsURL;
    private Boolean payTokenInd;
    private PayTokenSource payTokenSource;
    private String purchaseInstalData;
    private String mcc;
    private String merchantCountryCode;
    private String merchantName;
    private MerchantRiskIndicator merchantRiskIndicator;
    private MessageCategory messageCategory;
    private List<MessageExtension> messageExtension;
    private String notificationURL;
    private String purchaseAmount;
    private String purchaseCurrency;
    private String purchaseExponent;
    @JsonDeserialize(using = LocalDateTimeMinuteSecondDeserializer.class)
    @JsonSerialize(using = LocalDateTimeMinuteSecondSerializer.class)
    private LocalDateTime purchaseDate;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate recurringExpiry;
    private String recurringFrequency;
    private String sdkAppID;
    private String sdkEncData;
    private Map<String, String> sdkEphemPubKey;
    private String sdkMaxTimeout;
    private String sdkReferenceNumber;
    private String sdkTransID;
    private TransactionType transType;
    private WhiteListStatus whiteListStatus;
    private WhiteListStatusSource whiteListStatusSource;

    @JsonIgnore
    private LocalDateTime decoupledAuthMaxTime;

    @Override
    public String toString() {
        return "AReq{" +
                "super='" + super.toString() + '\'' +
                ", threeDSRequestorID='" + threeDSRequestorID + '\'' +
                ", threeDSRequestorName='" + threeDSRequestorName + '\'' +
                ", threeDSServerRefNumber='" + threeDSServerRefNumber + '\'' +
                ", threeDSServerOperatorID='" + threeDSServerOperatorID + '\'' +
                ", threeDSServerTransID='" + threeDSServerTransID + '\'' +
                ", acctType=" + acctType +
                ", acquirerBIN='" + acquirerBIN + '\'' +
                ", acquirerMerchantID='" + acquirerMerchantID + '\'' +
                ", acctNumber='" + AccountNumberUtils.hideAccountNumber(acctNumber) + '\'' +
                ", acctID='" + acctID + '\'' +
                ", email='" + email + '\'' +
                ", deviceChannel=" + deviceChannel +
                ", dsReferenceNumber='" + dsReferenceNumber + '\'' +
                ", dsTransID='" + dsTransID + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", messageCategory=" + messageCategory +
                ", purchaseAmount='" + purchaseAmount + '\'' +
                ", purchaseCurrency='" + purchaseCurrency + '\'' +
                ", sdkAppID='" + sdkAppID + '\'' +
                ", sdkReferenceNumber='" + sdkReferenceNumber + '\'' +
                ", sdkTransID='" + sdkTransID + '\'' +
                ", transType=" + transType +
                '}';
    }
}
