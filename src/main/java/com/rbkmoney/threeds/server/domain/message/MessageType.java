package com.rbkmoney.threeds.server.domain.message;

import com.fasterxml.jackson.annotation.JsonValue;
import com.rbkmoney.threeds.server.domain.Valuable;
import lombok.RequiredArgsConstructor;

/**
 * Identifies the type of message that is passed.
 */
@RequiredArgsConstructor
public enum MessageType implements Valuable {

    ERRO("Erro"),

    AREQ("AReq"),

    ARES("ARes"),

    PREQ("PReq"),

    PRES("PRes"),

    RREQ("RReq"),

    RRES("RRes"),

    PARQ("pArq"),

    PARS("pArs"),

    PGCQ("pGcq"),

    PGCS("pGcs"),

    PPRQ("pPrq"),

    PPRS("pPrs"),

    RBKMONEY_AUTHENTICATION_REQUEST("RBKMONEY_AUTHENTICATION_REQUEST"),

    RBKMONEY_AUTHENTICATION_RESPONSE("RBKMONEY_AUTHENTICATION_RESPONSE"),

    RBKMONEY_PREPARATION_REQUEST("RBKMONEY_PREPARATION_REQUEST"),

    RBKMONEY_PREPARATION_RESPONSE("RBKMONEY_PREPARATION_RESPONSE"),

    RBKMONEY_GET_CHALLENGE_REQUEST("RBKMONEY_GET_CHALLENGE_REQUEST"),

    RBKMONEY_GET_CHALLENGE_RESPONSE("RBKMONEY_GET_CHALLENGE_RESPONSE"),

    UNKN("Unkn");

    private final String value;

    @JsonValue
    @Override
    public String getValue() {
        return value;
    }
}
