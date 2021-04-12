package com.rbkmoney.threeds.server.utils;

import com.rbkmoney.threeds.server.domain.message.MessageType;
import com.rbkmoney.threeds.server.domain.root.Message;
import com.rbkmoney.threeds.server.domain.root.emvco.*;
import com.rbkmoney.threeds.server.domain.root.proprietary.*;
import com.rbkmoney.threeds.server.domain.root.rbkmoney.*;

public class MessageTypeUtils {

    public static MessageType resolve(Message message) {
        Class<? extends Message> messageClass = message.getClass();
        if (messageClass.equals(ErroWrapper.class) || messageClass.equals(Erro.class)) {
            return MessageType.ERRO;
        }
        if (messageClass.equals(AReq.class)) {
            return MessageType.AREQ;
        }
        if (messageClass.equals(ARes.class)) {
            return MessageType.ARES;
        }
        if (messageClass.equals(PReq.class)) {
            return MessageType.PREQ;
        }
        if (messageClass.equals(PRes.class)) {
            return MessageType.PRES;
        }
        if (messageClass.equals(RReq.class)) {
            return MessageType.RREQ;
        }
        if (messageClass.equals(RRes.class)) {
            return MessageType.RRES;
        }
        if (messageClass.equals(PArq.class)) {
            return MessageType.PARQ;
        }
        if (messageClass.equals(PArs.class)) {
            return MessageType.PARS;
        }
        if (messageClass.equals(PGcq.class)) {
            return MessageType.PGCQ;
        }
        if (messageClass.equals(PGcs.class)) {
            return MessageType.PGCS;
        }
        if (messageClass.equals(PPrq.class)) {
            return MessageType.PPRQ;
        }
        if (messageClass.equals(PPrs.class)) {
            return MessageType.PPRS;
        }
        if (messageClass.equals(RBKMoneyAuthenticationRequest.class)) {
            return MessageType.RBKMONEY_AUTHENTICATION_REQUEST;
        }
        if (messageClass.equals(RBKMoneyAuthenticationResponse.class)) {
            return MessageType.RBKMONEY_AUTHENTICATION_RESPONSE;
        }
        if (messageClass.equals(RBKMoneyPreparationRequest.class)) {
            return MessageType.RBKMONEY_PREPARATION_REQUEST;
        }
        if (messageClass.equals(RBKMoneyPreparationResponse.class)) {
            return MessageType.RBKMONEY_PREPARATION_RESPONSE;
        }
        if (messageClass.equals(RBKMoneyGetChallengeRequest.class)) {
            return MessageType.RBKMONEY_GET_CHALLENGE_REQUEST;
        }
        if (messageClass.equals(RBKMoneyGetChallengeResponse.class)) {
            return MessageType.RBKMONEY_GET_CHALLENGE_RESPONSE;
        }

        return MessageType.UNKN;
    }
}
