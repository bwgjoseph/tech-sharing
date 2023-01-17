package com.bwgjoseph.springbootmvc.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NameFormatValidator.class)
public @interface NameFormat {
    String message() default "invalid name format, must contain .";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
