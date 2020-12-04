package com.rbkmoney.threeds.server.domain.threedsmethod;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class ThreeDSMethod {

    private ThreeDSMethodData threeDSMethodData;
    @ToString.Exclude
    private String threeDSMethodURL;

}
