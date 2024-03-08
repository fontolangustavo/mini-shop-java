package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Supplier;

public interface FindSupplierByCnpjUseCase {
    Supplier findByCnpj(final String email);
}
