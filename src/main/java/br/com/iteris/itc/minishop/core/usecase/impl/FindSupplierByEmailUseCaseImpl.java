package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierByEmail;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.FindSupplierByEmailUseCase;
import br.com.iteris.itc.minishop.core.usecase.FindSupplierByIdUseCase;

import java.util.Optional;

public class FindSupplierByEmailUseCaseImpl implements FindSupplierByEmailUseCase {

    private final FindSupplierByEmail findSupplierByEmail;

    public FindSupplierByEmailUseCaseImpl(FindSupplierByEmail findSupplierByEmail) {
        this.findSupplierByEmail = findSupplierByEmail;
    }

    @Override
    public Supplier findByEmail(String email) {
        Optional<Supplier> supplier = findSupplierByEmail.findByEmail(email);

        if (supplier.isEmpty()) {
            throw new NotFoundException("Supplier not found");
        }

        return supplier.get();
    }
}
