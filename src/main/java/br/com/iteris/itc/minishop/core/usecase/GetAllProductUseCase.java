package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Product;
import org.springframework.data.domain.Page;

public interface GetAllProductUseCase {

    Page<Product> getAll(int page, int limit);
}
