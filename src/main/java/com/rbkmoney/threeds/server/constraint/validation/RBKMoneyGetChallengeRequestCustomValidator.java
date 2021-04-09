package com.rbkmoney.threeds.server.constraint.validation;

import com.rbkmoney.threeds.server.domain.root.rbkmoney.RBKMoneyGetChallengeRequest;
import com.rbkmoney.threeds.server.handle.constraint.ConstraintValidationHandler;
import com.rbkmoney.threeds.server.service.ValidatorContextEnricherService;

import java.util.List;

public class RBKMoneyGetChallengeRequestCustomValidator extends CustomValidator<RBKMoneyGetChallengeRequest> {

    public RBKMoneyGetChallengeRequestCustomValidator(
            List<ConstraintValidationHandler<RBKMoneyGetChallengeRequest>> constraintValidationHandlers,
            ValidatorContextEnricherService contextEnricher
    ) {
        super(constraintValidationHandlers, contextEnricher);
    }
}
