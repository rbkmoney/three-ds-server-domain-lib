package com.rbkmoney.threeds.server.constraint.validation;

import com.rbkmoney.threeds.server.domain.CardRange;
import com.rbkmoney.threeds.server.handle.constraint.ConstraintValidationHandler;
import com.rbkmoney.threeds.server.service.ValidatorContextEnricherService;

import java.util.List;

public class CardRangeCustomValidator extends CustomValidator<CardRange> {

    public CardRangeCustomValidator(List<ConstraintValidationHandler<CardRange>> constraintValidationHandlers,
                                    ValidatorContextEnricherService contextEnricher) {
        super(constraintValidationHandlers, contextEnricher);
    }
}
