package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.*;
import br.com.iteris.itc.minishop.core.usecase.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupplierConfig {
    @Bean
    public GetAllSupplierUseCaseImpl getAllSupplierUseCase(
            GetAllSupplier getAllSupplier
    ) {
        return new GetAllSupplierUseCaseImpl(getAllSupplier);
    }
    @Bean
    public FindSupplierByCnpjUseCaseImpl findSupplierByCnpjUseCase(
            FindSupplierByCnpj findSupplierByCnpj
    ) {
        return new FindSupplierByCnpjUseCaseImpl(findSupplierByCnpj);
    }
    @Bean
    public FindSupplierByEmailUseCaseImpl findSupplierByEmailUseCase(
            FindSupplierByEmail findSupplierByEmail
    ) {
        return new FindSupplierByEmailUseCaseImpl(findSupplierByEmail);
    }
    @Bean
    public FindSupplierByIdUseCaseImpl findSupplierByIdUseCase (
            FindSupplierById findSupplierById
    ) {
        return new FindSupplierByIdUseCaseImpl(findSupplierById);
    }
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
