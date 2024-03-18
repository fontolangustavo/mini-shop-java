package br.com.iteris.itc.minishop.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailResponse {
    private UUID id;
    private String name;
    private String phone;
    private String email;
    private double amountSpent;
}
