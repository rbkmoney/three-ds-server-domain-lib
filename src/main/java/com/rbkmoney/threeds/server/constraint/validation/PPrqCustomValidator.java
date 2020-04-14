package com.rbkmoney.threeds.server.constraint.validation;

import com.rbkmoney.threeds.server.domain.root.proprietary.PPrq;
import com.rbkmoney.threeds.server.handle.constraint.ConstraintValidationHandler;
import com.rbkmoney.threeds.server.service.ValidatorContextEnricherService;

import java.util.List;

public class PPrqCustomValidator extends CustomValidator<PPrq> {

    public PPrqCustomValidator(List<ConstraintValidationHandler<PPrq>> constraintValidationHandlers,
                               ValidatorContextEnricherService contextEnricher) {
        super(constraintValidationHandlers, contextEnricher);
    }
}
