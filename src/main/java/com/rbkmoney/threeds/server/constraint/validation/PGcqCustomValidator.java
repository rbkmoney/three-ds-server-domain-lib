package com.rbkmoney.threeds.server.constraint.validation;

import com.rbkmoney.threeds.server.domain.root.proprietary.PGcq;
import com.rbkmoney.threeds.server.handle.constraint.ConstraintValidationHandler;
import com.rbkmoney.threeds.server.service.ValidatorContextEnricherService;

import java.util.List;

public class PGcqCustomValidator extends CustomValidator<PGcq> {

    public PGcqCustomValidator(List<ConstraintValidationHandler<PGcq>> constraintValidationHandlers,
                               ValidatorContextEnricherService contextEnricher) {
        super(constraintValidationHandlers, contextEnricher);
    }
}
