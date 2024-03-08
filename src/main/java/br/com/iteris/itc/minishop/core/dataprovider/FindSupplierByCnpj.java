package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Supplier;

import java.util.Optional;

public interface FindSupplierByCnpj {
    Optional<Supplier> findByCnpj (final String cnpj);
}
