package com.rbkmoney.threeds.server.domain.root;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.rbkmoney.threeds.server.domain.root.emvco.*;
import com.rbkmoney.threeds.server.domain.root.proprietary.*;
import com.rbkmoney.threeds.server.domain.root.rbkmoney.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.lang.Nullable;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "messageType",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ErroWrapper.class, name = "Erro"),
        @JsonSubTypes.Type(value = AReq.class, name = "AReq"),
        @JsonSubTypes.Type(value = ARes.class, name = "ARes"),
        @JsonSubTypes.Type(value = PReq.class, name = "PReq"),
        @JsonSubTypes.Type(value = PRes.class, name = "PRes"),
        @JsonSubTypes.Type(value = RReq.class, name = "RReq"),
        @JsonSubTypes.Type(value = RRes.class, name = "RRes"),

        @JsonSubTypes.Type(value = PArq.class, name = "pArq"),
        @JsonSubTypes.Type(value = PArs.class, name = "pArs"),
        @JsonSubTypes.Type(value = PGcq.class, name = "pGcq"),
        @JsonSubTypes.Type(value = PGcs.class, name = "pGcs"),
        @JsonSubTypes.Type(value = PPrq.class, name = "pPrq"),
        @JsonSubTypes.Type(value = PPrs.class, name = "pPrs"),

        @JsonSubTypes.Type(value = RBKMoneyAuthenticationRequest.class, name = "RBKMONEY_AUTHENTICATION_REQUEST"),
        @JsonSubTypes.Type(value = RBKMoneyAuthenticationResponse.class, name = "RBKMONEY_AUTHENTICATION_RESPONSE"),
        @JsonSubTypes.Type(value = RBKMoneyPreparationRequest.class, name = "RBKMONEY_PREPARATION_REQUEST"),
        @JsonSubTypes.Type(value = RBKMoneyPreparationResponse.class, name = "RBKMONEY_PREPARATION_RESPONSE"),
        @JsonSubTypes.Type(value = RBKMoneyGetChallengeRequest.class, name = "RBKMONEY_GET_CHALLENGE_REQUEST"),
        @JsonSubTypes.Type(value = RBKMoneyGetChallengeResponse.class, name = "RBKMONEY_GET_CHALLENGE_RESPONSE"),
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@ToString(onlyExplicitlyIncluded = true)
public abstract class Message implements TransactionalMessage, RepeatableHandleMessage {

    @ToString.Include
    private String messageVersion;

    // 6.5.2 Test Case Identification (3ds.selftestplatform.com)
    @JsonIgnore
    private String ulTestCaseId;

    @JsonIgnore
    @Nullable
    private Message requestMessage;

    @JsonIgnore
    public boolean isRelevantMessageVersion() {
        if (messageVersion != null) {
            return messageVersion.equals("2.2.0");
        }

        return false;
    }
}
