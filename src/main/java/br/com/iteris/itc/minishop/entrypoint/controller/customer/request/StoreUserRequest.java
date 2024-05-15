package br.com.iteris.itc.minishop.entrypoint.controller.customer.request;

import br.com.iteris.itc.minishop.entrypoint.validators.EqualsValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
@EqualsValidator(field1 = "password", field2 = "passwordConfirmation", message = "teste")
public class StoreUserRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String passwordConfirmation;
    private Date birthDate;
    // Customer info's
    @NotBlank
    private String cpf;
    @NotBlank
    private String phone;
}
