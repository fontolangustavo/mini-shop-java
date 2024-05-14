package br.com.iteris.itc.minishop.entrypoint.validators.impl;

import br.com.iteris.itc.minishop.entrypoint.validators.EqualsValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.util.Objects;

public class EqualsValidatorImpl implements ConstraintValidator<EqualsValidator, Object> {
    private String field1;
    private String field2;

    @Override
    public void initialize(EqualsValidator constraintAnnotation) {
        field1 = constraintAnnotation.field1();
        field2 = constraintAnnotation.field2();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            Field field1 = value.getClass().getDeclaredField(this.field1);
            field1.setAccessible(true);
            Object fieldValue1 = field1.get(value);

            Field field2 = value.getClass().getDeclaredField(this.field2);
            field2.setAccessible(true);
            Object fieldValue2 = field2.get(value);

            return Objects.equals(fieldValue1, fieldValue2);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
