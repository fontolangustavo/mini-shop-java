package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.InsertProduct;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.usecase.InsertProductUseCase;
import org.springframework.stereotype.Component;

@Component
public class InsertProductUseCaseImpl implements InsertProductUseCase {

    private final InsertProduct insertProduct;
    public InsertProductUseCaseImpl(InsertProduct insertProduct) {
        this.insertProduct = insertProduct;
    }

    @Override
    public Product insert(Product product, String supplierId) {
        return this.insertProduct.insert(product, supplierId);
    }
}
