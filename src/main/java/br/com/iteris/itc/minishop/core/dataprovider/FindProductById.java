package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Product;

import java.util.Optional;

public interface FindProductById {
    Optional<Product> find(final String id);
}
