package com.rbkmoney.threeds.server.constraint.validation;

import com.rbkmoney.threeds.server.domain.root.rbkmoney.RBKMoneyAuthenticationRequest;
import com.rbkmoney.threeds.server.handle.constraint.ConstraintValidationHandler;
import com.rbkmoney.threeds.server.service.ValidatorContextEnricherService;

import java.util.List;

public class RBKMoneyAuthenticationRequestCustomValidator extends CustomValidator<RBKMoneyAuthenticationRequest> {

    public RBKMoneyAuthenticationRequestCustomValidator(
            List<ConstraintValidationHandler<RBKMoneyAuthenticationRequest>> constraintValidationHandlers,
            ValidatorContextEnricherService contextEnricher
    ) {
        super(constraintValidationHandlers, contextEnricher);
    }
}
