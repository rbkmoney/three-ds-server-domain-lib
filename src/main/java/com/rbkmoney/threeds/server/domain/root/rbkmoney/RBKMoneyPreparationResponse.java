package com.rbkmoney.threeds.server.domain.root.rbkmoney;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rbkmoney.threeds.server.domain.rbkmoney.cardrange.RBKMoneyCardRange;
import com.rbkmoney.threeds.server.domain.root.Message;
import lombok.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class RBKMoneyPreparationResponse extends Message {

    private String providerId;
    private String serialNum;
    private List<RBKMoneyCardRange> cardRanges;

    @Override
    public String toString() {
        return "RBKMoneyPreparationResponse{" +
                "super='" + super.toString() + '\'' +
                ", providerId='" + providerId + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", cardRanges='" + Optional.ofNullable(cardRanges).map(List::size).orElse(null) + '\'' +
                '}';
    }
}
