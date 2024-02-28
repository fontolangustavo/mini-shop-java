package br.com.iteris.itc.minishop.entrypoint.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProductWithSupplierResponse extends ProductResponse{
    private SupplierResponse supplier;

    public ProductWithSupplierResponse() {
    }

    public ProductWithSupplierResponse(UUID id, String name, BigDecimal price, boolean isDiscontinued) {
        super(id, name, price, isDiscontinued);
    }

    public ProductWithSupplierResponse(UUID id, String name, BigDecimal price, boolean isDiscontinued, SupplierResponse supplier) {
        super(id, name, price, isDiscontinued);
        this.supplier = supplier;
    }
}
