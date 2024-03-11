package br.com.iteris.itc.minishop.entrypoint.controller;

import br.com.iteris.itc.minishop.core.usecase.FindOrderByIdUseCase;
import br.com.iteris.itc.minishop.entrypoint.controller.mapper.OrderMapper;
import br.com.iteris.itc.minishop.entrypoint.controller.request.GetAllRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.response.OrderResponse;
import br.com.iteris.itc.minishop.core.usecase.GetAllOrderUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    @Autowired
    private GetAllOrderUseCase getAllOrderUseCase;
    @Autowired
    private FindOrderByIdUseCase findOrderByIdUseCase;
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping
    public ResponseEntity<Page<OrderResponse>> getAll(@Valid GetAllRequest request){
        var orders = getAllOrderUseCase.getAll(request.getPage(), request.getLimit());
        var response = orders.map(orderMapper::toOrderResponse);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> show(@PathVariable String id) {
        var order = findOrderByIdUseCase.find(id);

        var response = orderMapper.toOrderResponse(order);

        return ResponseEntity.ok().body(response);
    }
}
