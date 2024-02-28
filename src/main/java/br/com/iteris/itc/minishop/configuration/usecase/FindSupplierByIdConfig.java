package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierById;
import br.com.iteris.itc.minishop.core.usecase.FindSupplierByIdUseCase;
import br.com.iteris.itc.minishop.core.usecase.impl.FindSupplierByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSupplierByIdConfig {
    @Bean
    public FindSupplierByIdUseCaseImpl findSupplierByIdUseCase (
            FindSupplierById findSupplierById
    ) {
        return new FindSupplierByIdUseCaseImpl(findSupplierById);
    }
}
