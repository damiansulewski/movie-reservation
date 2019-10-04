package com.me.moviereservation.validation.constraint;

import com.me.moviereservation.validation.ValidSurname;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SurnameValidator implements ConstraintValidator<ValidSurname, String> {
    private static final String REGEXP_ONE_PART = "^[A-ZĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+$";
    private static final String REGEXP_TWO_PART = "^[A-ZĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+-[A-ZĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches(REGEXP_ONE_PART) || value.matches(REGEXP_TWO_PART);
    }
}
