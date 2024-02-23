package br.com.iteris.itc.minishop.entrypoint.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class SupplierWithProductsResponse extends SupplierResponse {
    private List<ProductResponse> products;

    public SupplierWithProductsResponse() {
    }

    public SupplierWithProductsResponse(UUID id, String name, String cnpj, String city, String uf, String phone, String email, String contact) {
        super(id, name, cnpj, city, uf, phone, email, contact);
    }

    public SupplierWithProductsResponse(UUID id, String name, String cnpj, String city, String uf, String phone, String email, String contact, List<ProductResponse> products) {
        super(id, name, cnpj, city, uf, phone, email, contact);
        this.products = products;
    }
}
