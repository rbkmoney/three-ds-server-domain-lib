package com.rbkmoney.threeds.server.domain.merchant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rbkmoney.threeds.server.domain.order.PreOrderPurchaseInd;
import com.rbkmoney.threeds.server.domain.order.ReorderItemsInd;
import com.rbkmoney.threeds.server.domain.ship.ShipIndicator;
import com.rbkmoney.threeds.server.serialization.deserializer.LocalDateDeserializer;
import com.rbkmoney.threeds.server.serialization.serializer.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class MerchantRiskIndicator {

    private String deliveryEmailAddress;
    private DeliveryTimeframe deliveryTimeframe;
    private String giftCardAmount;
    private String giftCardCount;
    private String giftCardCurr;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate preOrderDate;
    private PreOrderPurchaseInd preOrderPurchaseInd;
    private ReorderItemsInd reorderItemsInd;
    private ShipIndicator shipIndicator;

}
