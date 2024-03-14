package br.com.iteris.itc.minishop.entrypoint.controller.request;

import br.com.iteris.itc.minishop.entrypoint.validators.StateValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StoreCustomerRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String cpf;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
}
