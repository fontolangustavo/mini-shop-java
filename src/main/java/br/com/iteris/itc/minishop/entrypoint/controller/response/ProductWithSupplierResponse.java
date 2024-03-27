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

    public ProductWithSupplierResponse(UUID id, String name, BigDecimal price, String image, boolean isDiscontinued) {
        super(id, name, price, image, isDiscontinued);
    }

    public ProductWithSupplierResponse(UUID id, String name, BigDecimal price, String image, boolean isDiscontinued, SupplierResponse supplier) {
        super(id, name, price, image, isDiscontinued);
        this.supplier = supplier;
    }
}
