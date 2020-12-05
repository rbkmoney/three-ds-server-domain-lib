package com.rbkmoney.threeds.server.domain.threedsmethod;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class ThreeDsMethodRequest {

    private ThreeDsMethodData threeDsMethodData;
    @ToString.Exclude
    private String threeDsMethodUrl;

}
