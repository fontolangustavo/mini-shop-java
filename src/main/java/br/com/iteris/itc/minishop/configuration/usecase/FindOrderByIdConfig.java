package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindOrderById;
import br.com.iteris.itc.minishop.core.usecase.impl.FindOrderByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrderByIdConfig {
    @Bean
    public FindOrderByIdUseCaseImpl findOrderByIdUseCase(
            FindOrderById findOrderById
    ) {
        return new FindOrderByIdUseCaseImpl(findOrderById);
    }
}
