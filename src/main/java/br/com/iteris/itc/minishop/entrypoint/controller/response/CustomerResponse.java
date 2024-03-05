package br.com.iteris.itc.minishop.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CustomerResponse {
    private UUID id;
    private String name;
    private String phone;
    private String email;
}
