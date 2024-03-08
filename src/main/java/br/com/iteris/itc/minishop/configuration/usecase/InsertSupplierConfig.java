package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.*;
import br.com.iteris.itc.minishop.core.usecase.impl.InsertSupplierUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertSupplierConfig {
    @Bean
    public InsertSupplierUseCaseImpl insertSupplierUseCase(
            InsertSupplier insertSupplier,
            FindSupplierByEmail findSupplierByEmail,
            FindSupplierByCnpj findSupplierByCnpj
    ) {
        return new InsertSupplierUseCaseImpl(
                insertSupplier,
                findSupplierByEmail,
                findSupplierByCnpj
        );
    }
}
