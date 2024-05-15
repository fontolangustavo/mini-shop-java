package br.com.iteris.itc.minishop.entrypoint.controller.customer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private UUID id;
    private String name;
    private String type;
    private String password;
    private String email;
    private Date birthDate;
    private String createdAt;
    private String updatedAt;
    private CustomerResponse customer;

    public UserResponse(UUID id, String name, String type, String password, String email, Date birthDate, CustomerResponse customer) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.customer = customer;
    }
}
