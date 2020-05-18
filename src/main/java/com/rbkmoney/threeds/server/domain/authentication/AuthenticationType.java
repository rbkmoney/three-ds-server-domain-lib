package com.rbkmoney.threeds.server.domain.authentication;

import com.fasterxml.jackson.annotation.JsonValue;
import com.rbkmoney.threeds.server.domain.Valuable;
import lombok.RequiredArgsConstructor;

/**
 * Indicates the type of authentication method the Issuer will use to challenge the Cardholder,
 * whether in the ARes message or what was used by the ACS when in the RReq message.
 * <p>
 * Length: 2 characters
 * <p>
 * JSON Data Type: String
 */
@RequiredArgsConstructor
public enum AuthenticationType implements Valuable {

    STATIC("01"),

    DYNAMIC("02"),

    OOB("03"),

    DECOUPLED("04"),

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
