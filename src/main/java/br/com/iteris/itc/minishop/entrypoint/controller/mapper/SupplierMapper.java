package br.com.iteris.itc.minishop.entrypoint.controller.mapper;

import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.entrypoint.controller.response.ProductResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.SupplierWithProductsResponse;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {
    public SupplierWithProductsResponse toSupplierResponse(Supplier supplier) {
        return new SupplierWithProductsResponse(
                supplier.getId(),
                supplier.getName(),
                supplier.getCnpj(),
                supplier.getCity(),
                supplier.getUf(),
                supplier.getPhone(),
                supplier.getEmail(),
                supplier.getContact(),
                supplier.getProducts()
                        .stream()
                        .map((product) -> new ProductResponse(
                                product.getId(),
                                product.getName(),
                                product.getPrice(),
                                product.isDiscontinued()
                        )).toList()
        );
    }
}
