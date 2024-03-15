package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindAmountSpendOnOrderByCustomerId;
import br.com.iteris.itc.minishop.core.dataprovider.FindOrderById;
import br.com.iteris.itc.minishop.core.usecase.impl.FindAmountSpendOnOrderByCustomerIdUseCaseImpl;
import br.com.iteris.itc.minishop.core.usecase.impl.FindOrderByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAmountSpendOnOrderByCustomerIdConfig {
    @Bean
    public FindAmountSpendOnOrderByCustomerIdUseCaseImpl findAmountSpendOnOrderByCustomerIdUseCase(
            FindAmountSpendOnOrderByCustomerId findAmountSpendOnOrderByCustomerId
    ) {
        return new FindAmountSpendOnOrderByCustomerIdUseCaseImpl(
                findAmountSpendOnOrderByCustomerId
        );
    }
}
