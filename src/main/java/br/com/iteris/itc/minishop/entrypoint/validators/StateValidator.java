package br.com.iteris.itc.minishop.entrypoint.validators;

import br.com.iteris.itc.minishop.entrypoint.validators.impl.StateValidatorImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StateValidatorImpl.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StateValidator {
    String message() default "Invalid state provided";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
