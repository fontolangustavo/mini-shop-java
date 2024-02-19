package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Product;
import org.springframework.data.domain.Page;

public interface GetAllProduct {
    Page<Product> getAll(int page, int limit);
}
