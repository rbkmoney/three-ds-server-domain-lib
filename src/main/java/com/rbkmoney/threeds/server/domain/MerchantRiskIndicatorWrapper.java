package com.rbkmoney.threeds.server.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rbkmoney.threeds.server.domain.order.PreOrderPurchaseInd;
import com.rbkmoney.threeds.server.domain.order.ReorderItemsInd;
import com.rbkmoney.threeds.server.domain.ship.ShipIndicator;
import com.rbkmoney.threeds.server.serialization.EnumWrapper;
import com.rbkmoney.threeds.server.serialization.TemporalAccessorWrapper;
import com.rbkmoney.threeds.server.serialization.deserializer.*;
import com.rbkmoney.threeds.server.serialization.serializer.*;
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
public class MerchantRiskIndicatorWrapper {

    private String deliveryEmailAddress;
    @JsonDeserialize(using = DeliveryTimeframeDeserializer.class)
    @JsonSerialize(using = DeliveryTimeframeSerializer.class)
    private EnumWrapper<DeliveryTimeframe> deliveryTimeframe;
    private String giftCardAmount;
    private String giftCardCount;
    private String giftCardCurr;
    @JsonDeserialize(using = LocalDateWrapperDeserializer.class)
    @JsonSerialize(using = LocalDateWrapperSerializer.class)
    private TemporalAccessorWrapper<LocalDate> preOrderDate;
    @JsonDeserialize(using = PreOrderPurchaseIndDeserializer.class)
    @JsonSerialize(using = PreOrderPurchaseIndSerializer.class)
    private EnumWrapper<PreOrderPurchaseInd> preOrderPurchaseInd;
    @JsonDeserialize(using = ReorderItemsIndDeserializer.class)
    @JsonSerialize(using = ReorderItemsIndSerializer.class)
    private EnumWrapper<ReorderItemsInd> reorderItemsInd;
    @JsonDeserialize(using = ShipIndicatorDeserializer.class)
    @JsonSerialize(using = ShipIndicatorSerializer.class)
    private EnumWrapper<ShipIndicator> shipIndicator;

}
