package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.GetAllSupplier;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.usecase.GetAllSupplierUseCase;
import org.springframework.data.domain.Page;

public class GetAllSupplierUseCaseImpl implements GetAllSupplierUseCase {
    private final GetAllSupplier getAllSupplier;

    public GetAllSupplierUseCaseImpl(GetAllSupplier getAllSupplier) {
        this.getAllSupplier = getAllSupplier;
    }

    @Override
    public Page<Supplier> getAll(int page, int limit) {
        return getAllSupplier.getAll(page - 1, limit);
    }
}
