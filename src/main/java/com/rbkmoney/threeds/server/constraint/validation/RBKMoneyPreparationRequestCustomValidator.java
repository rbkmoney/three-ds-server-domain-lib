package com.rbkmoney.threeds.server.constraint.validation;

import com.rbkmoney.threeds.server.domain.root.rbkmoney.RBKMoneyPreparationRequest;
import com.rbkmoney.threeds.server.handle.constraint.ConstraintValidationHandler;
import com.rbkmoney.threeds.server.service.ValidatorContextEnricherService;

import java.util.List;

public class RBKMoneyPreparationRequestCustomValidator extends CustomValidator<RBKMoneyPreparationRequest> {

    public RBKMoneyPreparationRequestCustomValidator(List<ConstraintValidationHandler<RBKMoneyPreparationRequest>> constraintValidationHandlers,
                                                     ValidatorContextEnricherService contextEnricher) {
        super(constraintValidationHandlers, contextEnricher);
    }
}
