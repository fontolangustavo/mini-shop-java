package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;

public interface InsertSupplier {
    Supplier insert(Supplier supplier);
}
