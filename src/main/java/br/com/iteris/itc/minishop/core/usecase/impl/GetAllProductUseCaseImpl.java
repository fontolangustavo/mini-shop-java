package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.GetAllProduct;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.usecase.GetAllProductUseCase;
import org.springframework.data.domain.Page;

public class GetAllProductUseCaseImpl implements GetAllProductUseCase {

    private final GetAllProduct getAllProduct;

    public GetAllProductUseCaseImpl(GetAllProduct getAllProduct) {
        this.getAllProduct = getAllProduct;
    }

    @Override
    public Page<Product> getAll(int page, int limit) {
        return getAllProduct.getAll(page - 1, limit);
    }
}
