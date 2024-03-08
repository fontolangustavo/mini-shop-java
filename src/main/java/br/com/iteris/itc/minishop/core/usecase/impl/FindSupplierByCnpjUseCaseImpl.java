package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierByCnpj;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.FindSupplierByCnpjUseCase;

import java.util.Optional;

public class FindSupplierByCnpjUseCaseImpl implements FindSupplierByCnpjUseCase {

    private final FindSupplierByCnpj findSupplierByCnpj;

    public FindSupplierByCnpjUseCaseImpl(FindSupplierByCnpj findSupplierByCnpj) {
        this.findSupplierByCnpj = findSupplierByCnpj;
    }

    @Override
    public Supplier findByCnpj(String email) {
        Optional<Supplier> supplier = findSupplierByCnpj.findByCnpj(email);

        if (supplier.isEmpty()) {
            throw new NotFoundException("Supplier not found");
        }

        return supplier.get();
    }
}
