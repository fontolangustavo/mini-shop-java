package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.GetAllOrder;
import br.com.iteris.itc.minishop.core.domain.Order;
import br.com.iteris.itc.minishop.dataprovider.repository.OrderRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.OrderEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class GetAllOrderImpl implements GetAllOrder {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEntityMapper orderEntityMapper;

    @Override
    public Page<Order> getAll(int page, int limit) {
        var orders = orderRepository.findAll(PageRequest.of(page, limit));

        return orders.map(entity -> orderEntityMapper.toOrder(entity));
    }
}
