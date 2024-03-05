package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.GetAllCustomer;
import br.com.iteris.itc.minishop.core.usecase.impl.GetAllCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAllCustomerConfig {
    @Bean
    public GetAllCustomerUseCaseImpl getAllCustomerUseCase(
            GetAllCustomer getAllCustomer
    ) {
        return new GetAllCustomerUseCaseImpl(getAllCustomer);
    }
}
