package br.com.iteris.itc.minishop.entrypoint.validators.impl;

import br.com.iteris.itc.minishop.entrypoint.validators.StateValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class StateValidatorImpl implements ConstraintValidator<StateValidator, String> {
    private static final Set<String> states = new HashSet<>();
    static {
        states.add("AC");
        states.add("AL");
        states.add("AP");
        states.add("AM");
        states.add("BA");
        states.add("CE");
        states.add("DF");
        states.add("ES");
        states.add("GO");
        states.add("MA");
        states.add("MT");
        states.add("MS");
        states.add("MG");
        states.add("PA");
        states.add("PB");
        states.add("PR");
        states.add("PE");
        states.add("PI");
        states.add("RJ");
        states.add("RN");
        states.add("RS");
        states.add("RO");
        states.add("RR");
        states.add("SC");
        states.add("SP");
        states.add("SE");
        states.add("TO");
    }

    @Override
    public boolean isValid(String state, ConstraintValidatorContext constraintValidatorContext) {
        return state != null && states.contains(state.toUpperCase());
    }
}
