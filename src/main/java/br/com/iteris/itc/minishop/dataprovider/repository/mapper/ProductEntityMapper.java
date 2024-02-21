package br.com.iteris.itc.minishop.dataprovider.repository.mapper;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.ProductEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.SupplierEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntityMapper {
    @Autowired
    private SupplierEntityMapper supplierEntityMapper;

    public ProductEntity toProductEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setDiscontinued(product.isDiscontinued());

        if (product.getSupplier() != null ){
            SupplierEntity supplierEntity = supplierEntityMapper.toSupplierEntity(product.getSupplier());
            productEntity.setSupplier(supplierEntity);
        }

        return productEntity;
    }


    public Product toProduct(ProductEntity productEntity) {
        Product product = new Product();

        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        product.setDiscontinued(productEntity.isDiscontinued());

        if (productEntity.getSupplier() != null ){
            Supplier supplierEntity = supplierEntityMapper.toSupplier(productEntity.getSupplier());
            product.setSupplier(supplierEntity);
        }

        return product;
    }
}
