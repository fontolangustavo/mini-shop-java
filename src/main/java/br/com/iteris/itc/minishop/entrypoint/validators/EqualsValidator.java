package br.com.iteris.itc.minishop.entrypoint.validators;

import br.com.iteris.itc.minishop.entrypoint.validators.impl.EqualsValidatorImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import static java.lang.annotation.ElementType.*;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EqualsValidatorImpl.class)
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EqualsValidator {
    String message() default "The values of {field1} and {field2} must be equal";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String field1();
    String field2();
}
