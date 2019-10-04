package com.me.moviereservation.validation;

import com.me.moviereservation.validation.constraint.SurnameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = SurnameValidator.class)
public @interface ValidSurname {

    String message() default "{validation.message.invalid-surname}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
