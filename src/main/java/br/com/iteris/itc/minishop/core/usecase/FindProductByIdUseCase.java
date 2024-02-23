package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Product;

public interface FindProductByIdUseCase {

    Product find(final String id);
}
