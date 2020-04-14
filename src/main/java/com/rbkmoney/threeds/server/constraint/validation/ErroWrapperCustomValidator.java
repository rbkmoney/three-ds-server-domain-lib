package com.rbkmoney.threeds.server.constraint.validation;

import com.rbkmoney.threeds.server.domain.root.emvco.ErroWrapper;
import com.rbkmoney.threeds.server.handle.constraint.ConstraintValidationHandler;
import com.rbkmoney.threeds.server.service.ValidatorContextEnricherService;

import java.util.List;

public class ErroWrapperCustomValidator extends CustomValidator<ErroWrapper> {

    public ErroWrapperCustomValidator(List<ConstraintValidationHandler<ErroWrapper>> constraintValidationHandlers,
                                      ValidatorContextEnricherService contextEnricher) {
        super(constraintValidationHandlers, contextEnricher);
    }
}
