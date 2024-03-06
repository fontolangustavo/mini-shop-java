package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Supplier;

public interface FindSupplierByEmailUseCase {
    Supplier findByEmail(final String email);
}
