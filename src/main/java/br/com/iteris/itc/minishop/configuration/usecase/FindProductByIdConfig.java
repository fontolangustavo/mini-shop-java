package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindProductById;
import br.com.iteris.itc.minishop.core.usecase.impl.FindProductByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByIdConfig {
    @Bean
    public FindProductByIdUseCaseImpl findProductByIdUseCase(
            FindProductById findProductById
    ) {
        return new FindProductByIdUseCaseImpl(findProductById);
    }
}
