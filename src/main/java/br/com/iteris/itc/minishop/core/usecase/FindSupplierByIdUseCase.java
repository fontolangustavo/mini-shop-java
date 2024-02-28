package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Supplier;

public interface FindSupplierByIdUseCase {
    Supplier find(final String id);
}
