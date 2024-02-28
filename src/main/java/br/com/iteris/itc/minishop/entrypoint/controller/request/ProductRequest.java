package br.com.iteris.itc.minishop.entrypoint.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    @NotBlank
    private String name;
    @NotBlank
    private BigDecimal price;
    @NotBlank
    private String supplierId;
}
