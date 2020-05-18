package com.rbkmoney.threeds.server.domain.authentication;

import com.fasterxml.jackson.annotation.JsonValue;
import com.rbkmoney.threeds.server.domain.Valuable;
import lombok.RequiredArgsConstructor;

/**
 * Authentication approach that the ACS used to authenticate the Cardholder for this specific transaction.
 * Note: This is in the RReq message from the ACS only. It is not passed to the 3DS Server URL.
 * Note: For 3RI, only present for Decoupled Authentication
 */
@RequiredArgsConstructor
public enum AuthenticationMethod implements Valuable {

    STATIC_PASSCODE("01"),

    SMS_OTP("02"),

    KEY_FOB_OR_EMV_CARD_READER_OTP("03"),

    APP_OTP("04"),

    OTP_OTHER("05"),

    KBA("06"),

    OOB_BIOMETRICS("07"),

    OOB_LOGIN("08"),

    OOB_OTHER("09"),

    OTHER("10"),

    PUSH_CONFIRMATION("11"),

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
        return value.equals(PUSH_CONFIRMATION.getValue());
    }
}
