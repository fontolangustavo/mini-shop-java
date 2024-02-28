package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Supplier;

import java.util.Optional;

public interface FindSupplierById {
    Optional<Supplier> find (final String id);
}
