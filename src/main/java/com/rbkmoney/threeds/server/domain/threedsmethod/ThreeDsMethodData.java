package com.rbkmoney.threeds.server.domain.threedsmethod;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class ThreeDsMethodData {

    private String threeDSServerTransID;
    @ToString.Exclude
    private String threeDSMethodNotificationURL;

}
