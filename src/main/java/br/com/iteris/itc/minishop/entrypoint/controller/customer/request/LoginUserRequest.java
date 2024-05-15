package br.com.iteris.itc.minishop.entrypoint.controller.customer.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginUserRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
