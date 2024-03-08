package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.*;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.exceptions.ValidationException;
import br.com.iteris.itc.minishop.core.usecase.InsertSupplierUseCase;

import java.util.Optional;

public class InsertSupplierUseCaseImpl implements InsertSupplierUseCase {
    private final InsertSupplier insertSupplier;

    private final FindSupplierByEmail findSupplierByEmail;

    private final FindSupplierByCnpj findSupplierByCnpj;

    public InsertSupplierUseCaseImpl(
            InsertSupplier insertSupplier,
            FindSupplierByEmail findSupplierByEmail,
            FindSupplierByCnpj findSupplierByCnpj) {
        this.insertSupplier = insertSupplier;
        this.findSupplierByEmail = findSupplierByEmail;
        this.findSupplierByCnpj = findSupplierByCnpj;
    }

    @Override
    public Supplier insert(Supplier supplier) {
        Optional<Supplier> supplierWithSameEmail = findSupplierByEmail.findByEmail(supplier.getEmail());
        Optional<Supplier> supplierWithSameCnpj = findSupplierByCnpj.findByCnpj(supplier.getCnpj());

        if (supplierWithSameEmail.isPresent()) {
            throw  new ValidationException("That email address is already registered");
        }

        if (supplierWithSameCnpj.isPresent()) {
            throw  new ValidationException("That CNPJ is already registered");
        }

        return insertSupplier.insert(supplier);
    }
}
