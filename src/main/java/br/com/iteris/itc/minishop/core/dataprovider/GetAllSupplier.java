package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Supplier;
import org.springframework.data.domain.Page;

public interface GetAllSupplier {
    Page<Supplier> getAll(int page, int limit);
}
