package br.com.iteris.itc.minishop.entrypoint.controller.customer.request;

import br.com.iteris.itc.minishop.entrypoint.validators.EqualsValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@EqualsValidator(field1 = "password", field2 = "passwordConfirmation")
public class UpdateForgotPasswordRequest {
    @NotBlank
    private String password;
    @NotBlank
    private String passwordConfirmation;
}
