package com.rbkmoney.threeds.server.domain.rbkmoney.cardrange;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rbkmoney.threeds.server.domain.cardrange.ActionInd;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class RBKMoneyCardRange {

    private String startRange;
    private String endRange;
    private ActionInd actionInd;

}
