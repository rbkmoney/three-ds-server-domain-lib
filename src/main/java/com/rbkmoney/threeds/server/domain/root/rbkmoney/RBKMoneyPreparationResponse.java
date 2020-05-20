package com.rbkmoney.threeds.server.domain.root.rbkmoney;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rbkmoney.threeds.server.domain.root.Message;
import com.rbkmoney.threeds.server.dto.CardRangeDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class RBKMoneyPreparationResponse extends Message {

    private String providerId;
    private String serialNum;
    private List<CardRangeDTO> addedCardRanges;
    private List<CardRangeDTO> modifiedCardRanges;
    private List<CardRangeDTO> deletedCardRanges;
}
