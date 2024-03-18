package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindCustomerById;
import br.com.iteris.itc.minishop.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {
    @Bean
    public FindCustomerByIdUseCaseImpl findCustomerByIdUseCase(
            FindCustomerById findCustomerById
    ) {
        return new FindCustomerByIdUseCaseImpl(findCustomerById);
    }
}
