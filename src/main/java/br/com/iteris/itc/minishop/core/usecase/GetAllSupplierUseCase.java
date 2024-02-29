package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Supplier;
import org.springframework.data.domain.Page;

public interface GetAllSupplierUseCase {
    Page<Supplier> getAll(int page, int limit);
}
