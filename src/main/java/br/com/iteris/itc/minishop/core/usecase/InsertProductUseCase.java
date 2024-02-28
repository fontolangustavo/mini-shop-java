package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Product;

public interface InsertProductUseCase {
    Product insert(Product product, String supplierId);
}
