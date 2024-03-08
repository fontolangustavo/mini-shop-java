package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindOrderById;
import br.com.iteris.itc.minishop.core.domain.Order;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.FindOrderByIdUseCase;

import java.util.Optional;

public class FindOrderByIdUseCaseImpl implements FindOrderByIdUseCase {
    private final FindOrderById findOrderById;

    public FindOrderByIdUseCaseImpl(FindOrderById findOrderById) {
        this.findOrderById = findOrderById;
    }

    @Override
    public Order find(String id) {
        Optional<Order> order = findOrderById.find(id);

        if (order.isEmpty()) {
            throw new NotFoundException("Order not found");
        }

        return order.get();
    }
}
