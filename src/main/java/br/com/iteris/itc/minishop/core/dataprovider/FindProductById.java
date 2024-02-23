package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Product;

public interface FindProductById {
    Product find(final String id);
}
