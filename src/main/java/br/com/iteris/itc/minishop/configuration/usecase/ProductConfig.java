package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.*;
import br.com.iteris.itc.minishop.core.usecase.impl.FindProductByIdUseCaseImpl;
import br.com.iteris.itc.minishop.core.usecase.impl.GetAllProductUseCaseImpl;
import br.com.iteris.itc.minishop.core.usecase.impl.InsertProductUseCaseImpl;
import br.com.iteris.itc.minishop.core.usecase.impl.UpdateProductUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    public GetAllProductUseCaseImpl getAllProductUseCase(
            GetAllProduct getAllProduct
    ) {
        return new GetAllProductUseCaseImpl(getAllProduct);
    }
    @Bean
    public FindProductByIdUseCaseImpl findProductByIdUseCase(
            FindProductById findProductById
    ) {
        return new FindProductByIdUseCaseImpl(findProductById);
    }
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
