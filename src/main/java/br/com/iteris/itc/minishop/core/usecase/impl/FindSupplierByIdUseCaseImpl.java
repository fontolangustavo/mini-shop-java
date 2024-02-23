package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierById;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.FindSupplierByIdUseCase;

import java.util.Optional;

public class FindSupplierByIdUseCaseImpl implements FindSupplierByIdUseCase {

    private final FindSupplierById findSupplierById;

    public FindSupplierByIdUseCaseImpl(FindSupplierById findSupplierById) {
        this.findSupplierById = findSupplierById;
    }

    @Override
    public Supplier find(String id) {
        Optional<Supplier> supplier = findSupplierById.find(id);

        if (supplier.isEmpty()){
            throw new NotFoundException("Supplier not found");
        }

        return supplier.get();
    }
}
