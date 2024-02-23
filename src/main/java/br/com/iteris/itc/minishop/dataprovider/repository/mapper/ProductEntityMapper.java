package br.com.iteris.itc.minishop.dataprovider.repository.mapper;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.ProductEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.SupplierEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapper {
    public ProductEntity toProductEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();

        BeanUtils.copyProperties(product, productEntity);

        if (product.getSupplier() != null ){
            SupplierEntity supplierEntity = new SupplierEntity();
            BeanUtils.copyProperties(product.getSupplier(), supplierEntity);

            productEntity.setSupplier(supplierEntity);
        }

        return productEntity;
    }

    public Product toProduct(ProductEntity productEntity) {
        Product product = new Product();

        BeanUtils.copyProperties(productEntity, product);

        if (productEntity.getSupplier() != null ){
            Supplier supplier = new Supplier();

            BeanUtils.copyProperties(productEntity.getSupplier(), supplier);

            product.setSupplier(supplier);
        }

        return product;
    }
}
