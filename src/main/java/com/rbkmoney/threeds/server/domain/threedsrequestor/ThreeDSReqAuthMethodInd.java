package com.rbkmoney.threeds.server.domain.threedsrequestor;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * 3DS Requestor Authentication Method Verification Indicator
 * Value that represents the signature verification performed by the DS on the mechanism
 * (e.g., FIDO) used by the cardholder to authenticate to the 3DS Requestor.
 * <p>
 * Length: 2 characters
 * <p>
 * JSON Data Type: String
 */
@RequiredArgsConstructor
public enum ThreeDSReqAuthMethodInd {

    VERIFIED("01"),

    FAILED("02"),

    NOT_PERFORMED("03"),

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
    public String getValue() {
        return value;
    }
}
