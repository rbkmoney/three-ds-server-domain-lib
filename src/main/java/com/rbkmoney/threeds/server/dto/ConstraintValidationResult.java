package com.rbkmoney.threeds.server.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstraintValidationResult {

    private boolean isValid;

    private ConstraintType constraintType;

    private String fieldName;

    public static ConstraintValidationResult success() {
        ConstraintValidationResult constraintValidationResult = new ConstraintValidationResult();
        constraintValidationResult.setValid(true);
        return constraintValidationResult;
    }

    public static ConstraintValidationResult failure(ConstraintType constraintType, String fieldName) {
        ConstraintValidationResult constraintValidationResult = new ConstraintValidationResult();
        constraintValidationResult.setValid(false);
        constraintValidationResult.setConstraintType(constraintType);
        constraintValidationResult.setFieldName(fieldName);
        return constraintValidationResult;
    }
}
