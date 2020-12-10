package com.rbkmoney.threeds.server.domain.versioning;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class ThreeDsVersionResponse {

    private String threeDsServerTransId;
    private String dsProviderId;
    private String acsStartProtocolVersion;
    private String acsEndProtocolVersion;
    private String dsStartProtocolVersion;
    private String dsEndProtocolVersion;
    @ToString.Exclude
    private String threeDsMethodUrl;

}
