package com.rbkmoney.threeds.server.domain.root.emvco;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
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
    @ToString.Include
    private String threeDSRequestorID;
    @ToString.Include
    private String threeDSRequestorName;
    private ThreeDSRequestorPriorAuthenticationInfo threeDSRequestorPriorAuthenticationInfo;
    private String threeDSRequestorURL;
    @ToString.Include
    private String threeDSServerRefNumber;
    @ToString.Include
    private String threeDSServerOperatorID;
    @ToString.Include
    private String threeDSServerTransID;
    private String threeDSServerURL;
    private ThreeRIInd threeRIInd;
    @ToString.Include
    private AccountType acctType;
    @ToString.Include
    private String acquirerBIN;
    @ToString.Include
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
    @ToString.Include
    private String acctNumber;
    @ToString.Include
    private String acctID;
    @JsonUnwrapped(prefix = "bill")
    private Address billingAddress;
    @ToString.Include
    private String email;
    private Phone homePhone;
    private Phone mobilePhone;
    private String cardholderName;
    @JsonUnwrapped(prefix = "ship")
    private Address shippingAddress;
    private Phone workPhone;
    @ToString.Include
    private DeviceChannel deviceChannel;
    private String deviceInfo;
    private DeviceRenderOptions deviceRenderOptions;
    @ToString.Include
    private String dsReferenceNumber;
    @ToString.Include
    private String dsTransID;
    private String dsURL;
    private Boolean payTokenInd;
    private PayTokenSource payTokenSource;
    private String purchaseInstalData;
    private String mcc;
    private String merchantCountryCode;
    @ToString.Include
    private String merchantName;
    private MerchantRiskIndicator merchantRiskIndicator;
    @ToString.Include
    private MessageCategory messageCategory;
    private List<MessageExtension> messageExtension;
    private String notificationURL;
    @ToString.Include
    private String purchaseAmount;
    @ToString.Include
    private String purchaseCurrency;
    @ToString.Include
    private String purchaseExponent;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMddHHmmss")
    private LocalDateTime purchaseDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    private LocalDate recurringExpiry;
    private String recurringFrequency;
    @ToString.Include
    private String sdkAppID;
    private String sdkEncData;
    private Map<String, String> sdkEphemPubKey;
    private String sdkMaxTimeout;
    @ToString.Include
    private String sdkReferenceNumber;
    @ToString.Include
    private String sdkTransID;
    @ToString.Include
    private TransactionType transType;
    private WhiteListStatus whiteListStatus;
    private WhiteListStatusSource whiteListStatusSource;

    @JsonIgnore
    private LocalDateTime decoupledAuthMaxTime;

}
