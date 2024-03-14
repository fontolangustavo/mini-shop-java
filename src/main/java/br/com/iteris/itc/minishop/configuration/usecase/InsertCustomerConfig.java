package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.*;
import br.com.iteris.itc.minishop.core.usecase.impl.InsertCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {
    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(
            FindCustomerByCpf findCustomerByCpf,
            InsertCustomer insertCustomer
    ) {
        return new InsertCustomerUseCaseImpl(
                findCustomerByCpf,
                insertCustomer
        );
    }
}
