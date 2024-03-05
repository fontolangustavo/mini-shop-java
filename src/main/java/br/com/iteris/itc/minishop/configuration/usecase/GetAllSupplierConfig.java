package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.GetAllSupplier;
import br.com.iteris.itc.minishop.core.usecase.impl.GetAllSupplierUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAllSupplierConfig {
    @Bean
    public GetAllSupplierUseCaseImpl getAllSupplierUseCase(
            GetAllSupplier getAllSupplier
    ) {
        return new GetAllSupplierUseCaseImpl(getAllSupplier);
    }
}
