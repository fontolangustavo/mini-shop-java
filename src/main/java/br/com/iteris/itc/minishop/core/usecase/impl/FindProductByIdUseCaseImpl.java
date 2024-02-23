package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindProductById;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.usecase.FindProductByIdUseCase;

public class FindProductByIdUseCaseImpl implements FindProductByIdUseCase {
    private final FindProductById findProductById;

    public FindProductByIdUseCaseImpl(FindProductById findProductById) {
        this.findProductById = findProductById;
    }

    @Override
    public Product find(String id) {
        return findProductById.find(id);
    }
}
