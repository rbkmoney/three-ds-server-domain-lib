package com.rbkmoney.threeds.server.utils;

import com.rbkmoney.threeds.server.domain.message.MessageType;
import com.rbkmoney.threeds.server.domain.root.Message;
import com.rbkmoney.threeds.server.domain.root.emvco.*;
import com.rbkmoney.threeds.server.domain.root.proprietary.*;
import com.rbkmoney.threeds.server.domain.root.rbkmoney.*;

public class MessageTypeUtils {

    public static MessageType resolve(Message message) {
        Class<? extends Message> aClass = message.getClass();
        if (aClass.equals(ErroWrapper.class) || aClass.equals(Erro.class)) {
            return MessageType.ERRO;
        }
        if (aClass.equals(AReq.class)) {
            return MessageType.AREQ;
        }
        if (aClass.equals(ARes.class)) {
            return MessageType.ARES;
        }
        if (aClass.equals(PReq.class)) {
            return MessageType.PREQ;
        }
        if (aClass.equals(PRes.class)) {
            return MessageType.PRES;
        }
        if (aClass.equals(RReq.class)) {
            return MessageType.RREQ;
        }
        if (aClass.equals(RRes.class)) {
            return MessageType.RRES;
        }
        if (aClass.equals(PArq.class)) {
            return MessageType.PARQ;
        }
        if (aClass.equals(PArs.class)) {
            return MessageType.PARS;
        }
        if (aClass.equals(PGcq.class)) {
            return MessageType.PGCQ;
        }
        if (aClass.equals(PGcs.class)) {
            return MessageType.PGCS;
        }
        if (aClass.equals(PPrq.class)) {
            return MessageType.PPRQ;
        }
        if (aClass.equals(PPrs.class)) {
            return MessageType.PPRS;
        }
        if (aClass.equals(RBKMoneyAuthenticationRequest.class)) {
            return MessageType.RBKMONEY_AUTHENTICATION_REQUEST;
        }
        if (aClass.equals(RBKMoneyAuthenticationResponse.class)) {
            return MessageType.RBKMONEY_AUTHENTICATION_RESPONSE;
        }
        if (aClass.equals(RBKMoneyPreparationRequest.class)) {
            return MessageType.RBKMONEY_PREPARATION_REQUEST;
        }
        if (aClass.equals(RBKMoneyPreparationResponse.class)) {
            return MessageType.RBKMONEY_PREPARATION_RESPONSE;
        }
        if (aClass.equals(RBKMoneyGetChallengeRequest.class)) {
            return MessageType.RBKMONEY_GET_CHALLENGE_REQUEST;
        }
        if (aClass.equals(RBKMoneyGetChallengeResponse.class)) {
            return MessageType.RBKMONEY_GET_CHALLENGE_RESPONSE;
        }

        return MessageType.UNKN;
    }
}
