package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierById;
import br.com.iteris.itc.minishop.core.dataprovider.InsertProduct;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.dataprovider.repository.ProductRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.ProductEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.ProductEntityMapper;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.SupplierEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InsertProductImpl implements InsertProduct {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FindSupplierById findSupplierById;

    @Autowired
    private ProductEntityMapper productEntityMapper;
    @Autowired
    private SupplierEntityMapper supplierEntityMapper;

    @Override
    public Product insert(Product product, String supplierId) {
        Optional<Supplier> supplier = findSupplierById.find(supplierId);

        if (supplier.isEmpty()) {
            throw new NotFoundException("Supplier not found");
        }

        ProductEntity productWithSupplier = new ProductEntity(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.isDiscontinued(),
                supplierEntityMapper.toSupplierEntity(supplier.get())
        );


        ProductEntity productEntity = productRepository.save(productWithSupplier);

        return productEntityMapper.toProduct(productEntity);
    }
}
