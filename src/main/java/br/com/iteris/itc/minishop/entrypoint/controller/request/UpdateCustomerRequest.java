package br.com.iteris.itc.minishop.entrypoint.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateCustomerRequest {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String cpf;
    @NotNull
    private String email;
    @NotNull
    private String phone;
}
