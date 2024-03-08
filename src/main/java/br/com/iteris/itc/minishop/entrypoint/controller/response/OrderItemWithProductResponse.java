package br.com.iteris.itc.minishop.entrypoint.controller.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class OrderItemWithProductResponse  extends OrderItemResponse{
    private ProductResponse product;

    public OrderItemWithProductResponse() {
    }
    public OrderItemWithProductResponse(ProductResponse product) {
        this.product = product;
    }

    public OrderItemWithProductResponse(UUID id, int quantity, BigDecimal price, ProductResponse product) {
        super(id, quantity, price);
        this.product = product;
    }
}
