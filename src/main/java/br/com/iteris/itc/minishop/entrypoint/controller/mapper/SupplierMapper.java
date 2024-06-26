package br.com.iteris.itc.minishop.entrypoint.controller.mapper;

import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.entrypoint.controller.request.UpdateSupplierRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.response.ProductResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.SupplierResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.SupplierWithProductsResponse;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {
    public Supplier toSupplierFromUpdate(UpdateSupplierRequest supplierRequest) {
        return new Supplier(
                supplierRequest.getName(),
                supplierRequest.getCnpj(),
                supplierRequest.getCity(),
                supplierRequest.getUf(),
                supplierRequest.getPhone(),
                supplierRequest.getEmail(),
                supplierRequest.getContact()
        );
    }

    public SupplierResponse toSupplierResponse(Supplier supplier) {
        return new SupplierResponse(
                supplier.getId(),
                supplier.getName(),
                supplier.getCnpj(),
                supplier.getCity(),
                supplier.getUf(),
                supplier.getPhone(),
                supplier.getEmail(),
                supplier.getContact()
        );
    }
    public SupplierWithProductsResponse toSupplierWithProductsResponse(Supplier supplier) {
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
                                product.getImage(),
                                product.isDiscontinued()
                        )).toList()
        );
    }
}
