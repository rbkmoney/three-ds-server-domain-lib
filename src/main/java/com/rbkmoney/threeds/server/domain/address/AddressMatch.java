package com.rbkmoney.threeds.server.domain.address;

import com.fasterxml.jackson.annotation.JsonValue;
import com.rbkmoney.threeds.server.domain.Valuable;
import lombok.RequiredArgsConstructor;

/**
 * Indicates whether the Cardholder Shipping Address and Cardholder
 * Billing Address are the same.
 */
@RequiredArgsConstructor
public enum AddressMatch implements Valuable {

    SAME_ADDRESS("Y"),

    DIFFERENT_ADDRESS("N");

    private final String value;

    @JsonValue
    @Override
    public String getValue() {
        return value;
    }
}
