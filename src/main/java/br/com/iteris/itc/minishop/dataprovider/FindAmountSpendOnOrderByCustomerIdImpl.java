package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.FindAmountSpendOnOrderByCustomerId;
import br.com.iteris.itc.minishop.dataprovider.repository.OrderRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.OrderEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.OrderEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindAmountSpendOnOrderByCustomerIdImpl implements FindAmountSpendOnOrderByCustomerId {
    private final OrderRepository orderRepository;

    @Override
    public double find(String customerId) {
        return orderRepository.findAmountSpendOnOrderByCustomerId(UUID.fromString(customerId));
    }
}
