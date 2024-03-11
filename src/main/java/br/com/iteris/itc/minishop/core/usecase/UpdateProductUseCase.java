package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Product;

public interface UpdateProductUseCase {
    Product update(Product product, String supplierId);
}
