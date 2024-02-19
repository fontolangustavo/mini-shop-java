package br.com.iteris.itc.minishop.dataprovider.client.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductResponse {
    private UUID id;
    private String name;
    private BigDecimal price;
    private boolean isDiscontinued;
}
