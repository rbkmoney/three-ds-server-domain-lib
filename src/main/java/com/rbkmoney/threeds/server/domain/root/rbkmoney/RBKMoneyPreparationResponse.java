package com.rbkmoney.threeds.server.domain.root.rbkmoney;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rbkmoney.threeds.server.domain.rbkmoney.cardrange.CardRange;
import com.rbkmoney.threeds.server.domain.root.Message;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class RBKMoneyPreparationResponse extends Message {

    @ToString.Include
    private String providerId;
    @ToString.Include
    private String serialNum;
    private List<CardRange> addedCardRanges;
    private List<CardRange> modifiedCardRanges;
    private List<CardRange> deletedCardRanges;

}
