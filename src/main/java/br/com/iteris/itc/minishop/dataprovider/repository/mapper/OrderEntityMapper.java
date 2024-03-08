package br.com.iteris.itc.minishop.dataprovider.repository.mapper;

import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.core.domain.Order;
import br.com.iteris.itc.minishop.core.domain.OrderItem;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.CustomerEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.OrderEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.OrderItemEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.ProductEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityMapper {
    public OrderEntity toOrderEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();

        BeanUtils.copyProperties(order, orderEntity);

        if (order.getCustomer() != null) {
            CustomerEntity customerEntity = new CustomerEntity();
            BeanUtils.copyProperties(order.getCustomer(), customerEntity);

            orderEntity.setCustomer(customerEntity);
        }

        if (order.getOrderItems() != null) {
            orderEntity.setOrderItems(order.getOrderItems()
                    .stream()
                    .map(orderItem -> new OrderItemEntity(
                            orderItem.getId(),
                            orderItem.getQuantity(),
                            orderItem.getPrice(),
                            new ProductEntity(
                                orderItem.getProduct().getId(),
                                orderItem.getProduct().getName(),
                                orderItem.getProduct().getPrice(),
                                orderItem.getProduct().isDiscontinued()
                            )
                    ))
                    .toList()
            );
        }

        return orderEntity;
    }

    public Order toOrder(OrderEntity orderEntity) {
        Order order = new Order();

        BeanUtils.copyProperties(orderEntity, order);

        if (orderEntity.getCustomer() != null) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(orderEntity.getCustomer(), customer);

            order.setCustomer(customer);
        }

        if (orderEntity.getOrderItems() != null) {
            order.setOrderItems(orderEntity.getOrderItems()
                    .stream()
                    .map(orderItemEntity -> new OrderItem(
                            orderItemEntity.getId(),
                            orderItemEntity.getQuantity(),
                            orderItemEntity.getPrice(),
                            new Product(
                                    orderItemEntity.getProduct().getId(),
                                    orderItemEntity.getProduct().getName(),
                                    orderItemEntity.getProduct().getPrice(),
                                    orderItemEntity.getProduct().isDiscontinued()
                            )
                    ))
                    .toList()
            );
        }

        return order;
    }
}
