package br.com.iteris.itc.minishop.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private UUID id;
    private double amount;
    private String createdAt;
    private CustomerResponse customer;
    private List<OrderItemWithProductResponse> products;
}
