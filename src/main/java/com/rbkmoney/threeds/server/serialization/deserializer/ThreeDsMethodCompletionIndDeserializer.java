package com.rbkmoney.threeds.server.serialization.deserializer;

import com.rbkmoney.threeds.server.domain.threedsrequestor.ThreeDsMethodCompletionInd;
import com.rbkmoney.threeds.server.serialization.AbstractEnumDeserializer;

public class ThreeDsMethodCompletionIndDeserializer extends AbstractEnumDeserializer<ThreeDsMethodCompletionInd> {

    @Override
    protected ThreeDsMethodCompletionInd enumValueOf(String candidate) {
        return ThreeDsMethodCompletionInd.valueOf(candidate);
    }

    @Override
    protected ThreeDsMethodCompletionInd[] enumValues() {
        return ThreeDsMethodCompletionInd.values();
    }
}
