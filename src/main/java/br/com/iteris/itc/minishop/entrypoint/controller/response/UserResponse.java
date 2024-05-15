package br.com.iteris.itc.minishop.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private UUID id;
    private String name;
    private String type;
    private String password;
    private String email;
    private Date birthDate;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private CustomerResponse customer;
}
