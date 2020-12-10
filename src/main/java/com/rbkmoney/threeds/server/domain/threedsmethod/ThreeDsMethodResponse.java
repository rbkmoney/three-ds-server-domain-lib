package com.rbkmoney.threeds.server.domain.threedsmethod;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class ThreeDsMethodResponse {

    private String htmlThreeDsMethodData;

}
