package com.rbkmoney.threeds.server.domain.threedsrequestor;

import com.fasterxml.jackson.annotation.JsonValue;
import com.rbkmoney.threeds.server.domain.Valuable;
import lombok.RequiredArgsConstructor;

/**
 * 3RI Indicator.
 * Indicates the type of 3RI request.
 * This data element provides additional information to the ACS
 * to determine the best approach for handing a 3RI request.
 * <p>
 * Length: 2 characters
 * <p>
 * JSON Data Type: String
 */
@RequiredArgsConstructor
public enum ThreeRIInd implements Valuable {

    RECURRING_TRANSACTION("01"),

    INSTALMENT_TRANSACTION("02"),

    ADD_CARD("03"),

    MAINTAIN_CARD_INFO("04"),

    ACCOUNT_VERIFICATION("05"),

    SPLIT_OR_DELAYED_SHIPMENT("06"),

    TOP_UP("07"),

    MAIL_ORDER("08"),

    TELEPHONE_ORDER("09"),

    WHITELIST_STATUS_CHECK("10"),

    OTHER_PAYMENT("11"),

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

    public boolean isReservedValueForNotRelevantMessageVersion() {
        return value.equals(SPLIT_OR_DELAYED_SHIPMENT.getValue())
                || value.equals(TOP_UP.getValue())
                || value.equals(MAIL_ORDER.getValue())
                || value.equals(TELEPHONE_ORDER.getValue())
                || value.equals(WHITELIST_STATUS_CHECK.getValue())
                || value.equals(OTHER_PAYMENT.getValue());
    }
}
