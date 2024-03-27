package br.com.iteris.itc.minishop.entrypoint.controller.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private UUID id;
    private String name;
    private BigDecimal price;
    private String image;
    private boolean isDiscontinued;
}
