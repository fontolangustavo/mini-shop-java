package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierById;
import br.com.iteris.itc.minishop.core.dataprovider.UpdateSupplier;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.UpdateSupplierUseCase;

import java.util.Optional;

public class UpdateSupplierUseCaseImpl implements UpdateSupplierUseCase {
    private final UpdateSupplier updateSupplier;

    private final FindSupplierById findSupplierById;

    public UpdateSupplierUseCaseImpl(
            UpdateSupplier updateSupplier,
            FindSupplierById findSupplierById) {
        this.updateSupplier = updateSupplier;
        this.findSupplierById = findSupplierById;
    }

    @Override
    public Supplier update(Supplier supplier) {
        Optional<Supplier> supplierExists = findSupplierById.find(supplier.getId().toString());
        if (supplierExists.isEmpty()) {
            throw new NotFoundException("Supplier not found");
        }

        return updateSupplier.update(supplier);
    }
}
