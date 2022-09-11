package com.spring.mvc.own_annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailCheckerValidator implements ConstraintValidator<EmailChecker, String> {
    private String properValue;

    @Override
    public void initialize(EmailChecker emailChecker) {
        properValue = emailChecker.value();        // = "@company.com"
    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue.endsWith(properValue);
    }
}