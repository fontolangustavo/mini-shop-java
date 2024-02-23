package br.com.iteris.itc.minishop.dataprovider.repository.mapper;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.ProductEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.SupplierEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SupplierEntityMapper {

    public SupplierEntity toSupplierEntity(Supplier supplier) {
        SupplierEntity supplierEntity = new SupplierEntity();

        BeanUtils.copyProperties(supplier, supplierEntity);

        supplierEntity.setProducts(supplierEntity.getProducts()
                .stream()
                .map(product -> new ProductEntity(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.isDiscontinued()
                ))
                .toList()
        );

        return supplierEntity;
    }

    public Supplier toSupplier(SupplierEntity supplierEntity) {
        Supplier supplier = new Supplier();

        BeanUtils.copyProperties(supplierEntity, supplier);

        supplier.setProducts(supplierEntity.getProducts()
                .stream()
                .map(productEntity -> new Product(
                        productEntity.getId(),
                        productEntity.getName(),
                        productEntity.getPrice(),
                        productEntity.isDiscontinued()
                ))
                .toList()
        );

        return supplier;
    }
}
