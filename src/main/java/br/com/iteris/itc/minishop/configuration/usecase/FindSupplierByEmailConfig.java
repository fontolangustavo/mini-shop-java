package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierByEmail;
import br.com.iteris.itc.minishop.core.usecase.impl.FindSupplierByEmailUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSupplierByEmailConfig {
    @Bean
    public FindSupplierByEmailUseCaseImpl findSupplierByEmailUseCase(
            FindSupplierByEmail findSupplierByEmail
    ) {
        return new FindSupplierByEmailUseCaseImpl(findSupplierByEmail);
    }

}
