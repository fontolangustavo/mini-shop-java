package br.com.iteris.itc.minishop.entrypoint.controller.mapper;

import br.com.iteris.itc.minishop.core.domain.Order;
import br.com.iteris.itc.minishop.entrypoint.controller.response.CustomerResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.OrderItemWithProductResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.OrderResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.ProductResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class OrderMapper {
    public OrderResponse toOrderResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();

        BeanUtils.copyProperties(order, orderResponse);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        orderResponse.setCreatedAt(order.getCreatedAt().format(formatter));

        if (order.getCustomer() != null) {
            CustomerResponse customerResponse = new CustomerResponse();

            BeanUtils.copyProperties(order.getCustomer(), customerResponse);

            orderResponse.setCustomer(customerResponse);
        }

        if (order.getOrderItems() != null) {
            List<OrderItemWithProductResponse> orderItemWithProductResponses = order.getOrderItems()
                    .stream()
                    .map((orderItem) -> new OrderItemWithProductResponse(
                            orderItem.getId(),
                            orderItem.getQuantity(),
                            orderItem.getPrice(),
                            new ProductResponse(
                                    orderItem.getProduct().getId(),
                                    orderItem.getProduct().getName(),
                                    orderItem.getProduct().getPrice(),
                                    orderItem.getProduct().getImage(),
                                    orderItem.getProduct().isDiscontinued()
                            )
                    )).toList();

            orderResponse.setProducts(orderItemWithProductResponses);
        }

        return orderResponse;
    }
}
