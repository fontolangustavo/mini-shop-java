package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierById;
import br.com.iteris.itc.minishop.core.dataprovider.UpdateSupplier;
import br.com.iteris.itc.minishop.core.usecase.impl.UpdateSupplierUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateSupplierConfig {
    @Bean
    public UpdateSupplierUseCaseImpl updateSupplierUseCase(
            UpdateSupplier updateSupplier,
            FindSupplierById findSupplierById
    ) {
        return new UpdateSupplierUseCaseImpl(
                updateSupplier,
                findSupplierById
        );
    }
}
