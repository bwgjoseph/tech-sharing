package com.bwgjoseph.springbootmvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameFormatValidator implements ConstraintValidator<NameFormat, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.contains(".");
    }

}
