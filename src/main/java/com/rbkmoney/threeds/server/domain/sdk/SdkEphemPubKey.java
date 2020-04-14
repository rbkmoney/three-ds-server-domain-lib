package com.rbkmoney.threeds.server.domain.sdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class SdkEphemPubKey {

    private String kty;
    private String crv;
    private String x;
    private String y;

}
