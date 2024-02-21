package br.com.iteris.itc.minishop.entrypoint.controller.response;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class SupplierResponse {
    private UUID id;
    private String name;
    private String cnpj;
    private String city;
    private String uf;
    private String phone;
    private String email;
    private String contact;
}
