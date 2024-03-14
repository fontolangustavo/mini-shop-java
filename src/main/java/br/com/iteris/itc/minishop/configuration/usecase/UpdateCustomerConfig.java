package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.*;
import br.com.iteris.itc.minishop.core.usecase.impl.UpdateCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {
    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(
            UpdateCustomer updateCustomer,
            FindCustomerById findCustomerById
    ) {
        return new UpdateCustomerUseCaseImpl(
                updateCustomer,
                findCustomerById
        );
    }
}
