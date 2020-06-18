package com.rbkmoney.threeds.server.domain.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rbkmoney.threeds.server.domain.ship.ShipAddressUsageInd;
import com.rbkmoney.threeds.server.domain.ship.ShipNameIndicator;
import com.rbkmoney.threeds.server.serialization.deserializer.LocalDateDeserializer;
import com.rbkmoney.threeds.server.serialization.serializer.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Cardholder Account Information.
 * Additional information about the Cardholder’s account provided by the 3DS Requestor.
 * <p>
 * JSON Data Type: Object
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class AccountInfo {

    private ChAccAgeInd chAccAgeInd;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate chAccChange;
    private ChAccChangeInd chAccChangeInd;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate chAccDate;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate chAccPwChange;
    private ChAccPwChangeInd chAccPwChangeInd;
    private String nbPurchaseAccount;
    private String provisionAttemptsDay;
    private String txnActivityDay;
    private String txnActivityYear;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate paymentAccAge;
    private PaymentAccInd paymentAccInd;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate shipAddressUsage;
    private ShipAddressUsageInd shipAddressUsageInd;
    private ShipNameIndicator shipNameIndicator;
    private SuspiciousAccActivity suspiciousAccActivity;

}
