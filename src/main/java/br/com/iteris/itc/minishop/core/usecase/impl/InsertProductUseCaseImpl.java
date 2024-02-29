package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierById;
import br.com.iteris.itc.minishop.core.dataprovider.InsertProduct;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.InsertProductUseCase;

import java.util.Optional;

public class InsertProductUseCaseImpl implements InsertProductUseCase {
    private final InsertProduct insertProduct;

    private final FindSupplierById findSupplierById;

    public InsertProductUseCaseImpl(InsertProduct insertProduct, FindSupplierById findSupplierById) {
        this.insertProduct = insertProduct;
        this.findSupplierById = findSupplierById;
    }

    @Override
    public Product insert(Product product, String supplierId) {
        Optional<Supplier> supplier = findSupplierById.find(supplierId);

        if (supplier.isEmpty()) {
            throw new NotFoundException("Supplier not found");
        }

        product.setSupplier(supplier.get());
                
        return insertProduct.insert(product);
    }
}
