package com.rbkmoney.threeds.server.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class CardRangeDTO {

    private String startRange;
    private String endRange;
}
