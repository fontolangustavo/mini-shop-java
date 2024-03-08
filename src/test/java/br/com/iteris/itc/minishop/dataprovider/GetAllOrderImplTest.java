package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Order;
import br.com.iteris.itc.minishop.core.usecase.GetAllOrderUseCase;
import br.com.iteris.itc.minishop.dataprovider.repository.OrderRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.OrderRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.OrderEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.OrderEntityMapper;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.OrderEntityMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetAllOrderImplTest {
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderEntityMapper orderEntityMapper;

    @InjectMocks
    private GetAllOrderImpl getAllOrder;

    @Test
    @DisplayName("should return pagable with a list of orders")
    public void testGetAllOrdersPaginated() {
        int page = 1;
        int pageSize = 10;
        UUID orderId = UUID.randomUUID();

        List<OrderEntity> orderEntities = new ArrayList<>();
        orderEntities.add(new OrderEntity(
                orderId,
                12.34,
                ZonedDateTime.now()
        ));
        orderEntities.add(new OrderEntity(
                orderId,
                12.34,
                ZonedDateTime.now()
        ));
        Page<OrderEntity> mockOrderEntities = new PageImpl<>(orderEntities);

        when(orderRepository.findAll(PageRequest.of(page, pageSize))).thenReturn(mockOrderEntities);

        Page<Order> result = getAllOrder.getAll(page, pageSize);

        // Asserts
        assertEquals(2, result.getTotalElements());
    }

    @Test
    @DisplayName("should return pagable with a empty list of orders")
    public void testGetAllOrdersWithEmptyList() {
        int page = 1;
        int pageSize = 10;

        Page<OrderEntity> mockOrderEntities = new PageImpl<>(new ArrayList<>());

        when(orderRepository.findAll(PageRequest.of(page, pageSize))).thenReturn(mockOrderEntities);


        Page<Order> result = getAllOrder.getAll(page, pageSize);

        // Asserts
        assertEquals(0, result.getTotalElements());
    }
}
