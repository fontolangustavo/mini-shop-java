package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierById;
import br.com.iteris.itc.minishop.core.dataprovider.InsertProduct;
import br.com.iteris.itc.minishop.core.usecase.impl.InsertProductUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertProductConfig {
    @Bean
    public InsertProductUseCaseImpl insertProductUseCase(
            InsertProduct insertProduct,
            FindSupplierById findSupplierById
    ) {
        return new InsertProductUseCaseImpl(
                insertProduct,
                findSupplierById
        );
    }
}
