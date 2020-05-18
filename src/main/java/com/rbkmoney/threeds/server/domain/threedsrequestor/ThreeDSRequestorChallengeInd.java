package com.rbkmoney.threeds.server.domain.threedsrequestor;

import com.fasterxml.jackson.annotation.JsonValue;
import com.rbkmoney.threeds.server.domain.Valuable;
import lombok.RequiredArgsConstructor;

/**
 * 3DS Requestor Challenge Indicator
 * Indicates whether a challenge is requested for this transaction.
 * <p>
 * Length: 2 characters
 * <p>
 * JSON Data Type: String
 */
@RequiredArgsConstructor
public enum ThreeDSRequestorChallengeInd implements Valuable {

    NO_PREFERENCE("01"), //default

    NO_CHALLENGE("02"),

    CHALLENGE_REQUESTED_BY_REQUESTOR("03"),

    CHALLENGE_REQUESTED_MANDATE("04"),

    NO_CHALLENGE_RISK_ANALYSIS_PERFORMED("05"),

    NO_CHALLENGE_DATA_SHARE_ONLY("06"),

    NO_CHALLENGE_AUTH_ALREADY_PERFORMED("07"),

    NO_CHALLENGE_UTILISE_WHITELIST_EXEMPTION("08"),

    CHALLENGE_REQUESTED_WHITELIST_PROMPT_REQUESTED("09"),

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
        return value.equals(NO_CHALLENGE_RISK_ANALYSIS_PERFORMED.getValue())
                || value.equals(NO_CHALLENGE_DATA_SHARE_ONLY.getValue())
                || value.equals(NO_CHALLENGE_AUTH_ALREADY_PERFORMED.getValue())
                || value.equals(NO_CHALLENGE_UTILISE_WHITELIST_EXEMPTION.getValue())
                || value.equals(CHALLENGE_REQUESTED_WHITELIST_PROMPT_REQUESTED.getValue());
    }
}
