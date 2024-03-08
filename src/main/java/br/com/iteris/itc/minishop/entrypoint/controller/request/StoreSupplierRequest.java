package br.com.iteris.itc.minishop.entrypoint.controller.request;

import br.com.iteris.itc.minishop.entrypoint.validators.StateValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StoreSupplierRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String cnpj;
    @NotBlank
    private String city;
    @NotBlank
    @StateValidator()
    private String uf;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
    @NotBlank
    private String contact;
}
