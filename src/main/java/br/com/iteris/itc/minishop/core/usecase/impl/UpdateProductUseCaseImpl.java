package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindProductById;
import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierById;
import br.com.iteris.itc.minishop.core.dataprovider.UpdateProduct;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.UpdateProductUseCase;

import java.util.Optional;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {
    private final UpdateProduct updateProduct;

    private final FindProductById findProductById;

    private final FindSupplierById findSupplierById;

    public UpdateProductUseCaseImpl(
            UpdateProduct updateProduct,
            FindProductById findProductById,
            FindSupplierById findSupplierById) {
        this.updateProduct = updateProduct;
        this.findProductById = findProductById;
        this.findSupplierById = findSupplierById;
    }

    @Override
    public Product update(Product product, String supplierId) {
        Optional<Product> productExists = findProductById.find(product.getId().toString());
        if (productExists.isEmpty()) {
            throw new NotFoundException("Product not found");
        }

        Optional<Supplier> supplier = findSupplierById.find(supplierId);
        if (supplier.isEmpty()) {
            throw new NotFoundException("Supplier not found");
        }

        product.setSupplier(supplier.get());

        return updateProduct.update(product);
    }
}
