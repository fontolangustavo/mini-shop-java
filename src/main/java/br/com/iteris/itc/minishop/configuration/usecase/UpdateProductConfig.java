package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindProductById;
import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierById;
import br.com.iteris.itc.minishop.core.dataprovider.UpdateProduct;
import br.com.iteris.itc.minishop.core.usecase.impl.UpdateProductUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateProductConfig {
    @Bean
    public UpdateProductUseCaseImpl updateProductUseCase(
            UpdateProduct updateProduct,
            FindProductById findProductById,
            FindSupplierById findSupplierById
    ) {
        return new UpdateProductUseCaseImpl(
                updateProduct,
                findProductById,
                findSupplierById
        );
    }
}
