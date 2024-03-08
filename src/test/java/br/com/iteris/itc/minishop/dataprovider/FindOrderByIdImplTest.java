package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Order;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.dataprovider.repository.OrderRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.OrderEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.SupplierEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.OrderEntityMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FindOrderByIdImplTest {
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderEntityMapper mockOrderEntityMapper;

    @InjectMocks
    private FindOrderByIdImpl findOrderById;

    @Test
    @DisplayName("should return order on success")
    public void testFindOrderByIdOnSuccess() {
        UUID orderId = UUID.randomUUID();
        String orderIdString = orderId.toString();

        OrderEntity mockOrder= new OrderEntity(orderId, 123.54, ZonedDateTime.now());

        when(mockOrderEntityMapper.toOrder(any(OrderEntity.class))).thenReturn(new Order(orderId, 123.54, ZonedDateTime.now(), null, null));
        when(orderRepository.findById(any(UUID.class))).thenReturn(Optional.of(mockOrder));

        Optional<Order> response = findOrderById.find(orderIdString);

        assertAll("should return order on success",
                () -> assertTrue(response.isPresent()),
                () -> assertEquals(mockOrder.getId(), response.get().getId()),
                () -> verify(mockOrderEntityMapper, times(1)).toOrder(mockOrder)
        );
    }

    @Test
    @DisplayName("should throw when id is illegal")
    public void testShouldThrowWhenIdIsIllegal() {
        UUID orderId = UUID.randomUUID();
        String orderIdString = orderId.toString();

        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());


        Optional<Order> response = findOrderById.find(orderIdString);

        //Asserts
        assertTrue(response.isEmpty());
    }
    @Test
    @DisplayName("should throw when order not found")
    public void testShouldThrowWhenOrderNotFound() {
        UUID orderId = UUID.randomUUID();
        String orderIdString = orderId.toString();

        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        Optional<Order> response = findOrderById.find(orderIdString);

        //Asserts
        assertTrue(response.isEmpty());
    }
}
