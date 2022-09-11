package com.spring.mvc.own_annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailCheckerValidator.class)
public @interface EmailChecker {
    public String value() default "@company.com";

    public String message() default "only company emails are accepted";

    public Class<?>[] groups() default{};                       // groups позволяет разбивать аннотации по группам
    public Class<? extends Payload> [] payload() default {};    // payload используется для переноса метаданных клиента

}