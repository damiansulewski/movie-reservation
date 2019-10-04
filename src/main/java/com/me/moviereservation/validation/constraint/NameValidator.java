package com.me.moviereservation.validation.constraint;

import com.me.moviereservation.validation.ValidName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {
    private static final String regexp = "^[A-ZĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches(regexp);
    }
}
