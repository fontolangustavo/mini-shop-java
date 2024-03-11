package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.FindOrderById;
import br.com.iteris.itc.minishop.core.domain.Order;
import br.com.iteris.itc.minishop.dataprovider.repository.OrderRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.OrderEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.OrderEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindOrderByIdImpl implements FindOrderById {
    private final OrderRepository orderRepository;

    private final OrderEntityMapper orderEntityMapper;

    @Override
    public Optional<Order> find(String id) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(UUID.fromString(id));

        return orderEntity.map(orderEntityMapper::toOrder);
    }
}
