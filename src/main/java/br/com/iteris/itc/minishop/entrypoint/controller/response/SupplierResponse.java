package br.com.iteris.itc.minishop.entrypoint.controller.response;

import lombok.*;

import java.util.UUID;
@Data
@NoArgsConstructor
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
