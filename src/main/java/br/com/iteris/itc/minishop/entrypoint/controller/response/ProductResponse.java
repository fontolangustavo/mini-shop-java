package br.com.iteris.itc.minishop.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ProductResponse {
    private UUID id;
    private String name;
    private BigDecimal price;
    private boolean isDiscontinued;
}
