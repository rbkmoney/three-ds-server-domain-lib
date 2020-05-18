package com.rbkmoney.threeds.server.domain.threedsrequestor;

import com.fasterxml.jackson.annotation.JsonValue;
import com.rbkmoney.threeds.server.domain.Valuable;
import lombok.RequiredArgsConstructor;

/**
 * 3DS Requestor Authentication Indicator
 * <p>
 * Indicates the type of Authentication request.
 * This data element provides additional information to the ACS to determine the best
 * approach for handing an authentication request.
 * <p>
 * Length: 2 characters
 * <p>
 * JSON Data Type: String
 */
@RequiredArgsConstructor
public enum ThreeDSRequestorAuthenticationInd implements Valuable {

    PAYMENT_TRANSACTION("01"),

    RECURRING_TRANSACTION("02"),

    INSTALMENT_TRANSACTION("03"),

    ADD_CARD("04"),

    MAINTAIN_CARD("05"),

    CARDHOLDER_VERIFICATION("06"),

    RESERVED_FOR_DS_USED_80("80"),
    RESERVED_FOR_DS_USED_81("81"),
    RESERVED_FOR_DS_USED_82("82"),
    RESERVED_FOR_DS_USED_83("83"),
    RESERVED_FOR_DS_USED_84("84"),
    RESERVED_FOR_DS_USED_85("85"),
    RESERVED_FOR_DS_USED_86("86"),
    RESERVED_FOR_DS_USED_87("87"),
    RESERVED_FOR_DS_USED_88("88"),
    RESERVED_FOR_DS_USED_89("89"),
    RESERVED_FOR_DS_USED_90("90"),
    RESERVED_FOR_DS_USED_91("91"),
    RESERVED_FOR_DS_USED_92("92"),
    RESERVED_FOR_DS_USED_93("93"),
    RESERVED_FOR_DS_USED_94("94"),
    RESERVED_FOR_DS_USED_95("95"),
    RESERVED_FOR_DS_USED_96("96"),
    RESERVED_FOR_DS_USED_97("97"),
    RESERVED_FOR_DS_USED_98("98"),
    RESERVED_FOR_DS_USED_99("99");

    private final String value;

    @JsonValue
    @Override
    public String getValue() {
        return value;
    }
}
