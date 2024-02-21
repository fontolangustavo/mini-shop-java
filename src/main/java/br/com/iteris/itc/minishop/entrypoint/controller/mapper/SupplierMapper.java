package br.com.iteris.itc.minishop.entrypoint.controller.mapper;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.entrypoint.controller.request.ProductRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.response.ProductResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.SupplierResponse;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {
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
}
