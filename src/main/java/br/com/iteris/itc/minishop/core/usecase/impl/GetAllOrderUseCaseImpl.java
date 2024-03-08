package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.GetAllOrder;
import br.com.iteris.itc.minishop.core.dataprovider.GetAllProduct;
import br.com.iteris.itc.minishop.core.domain.Order;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.usecase.GetAllOrderUseCase;
import br.com.iteris.itc.minishop.core.usecase.GetAllProductUseCase;
import org.springframework.data.domain.Page;

public class GetAllOrderUseCaseImpl implements GetAllOrderUseCase {

    private final GetAllOrder getAllOrder;

    public GetAllOrderUseCaseImpl(GetAllOrder getAllOrder) {
        this.getAllOrder = getAllOrder;
    }

    @Override
    public Page<Order> getAll(int page, int limit) {
        return getAllOrder.getAll(page - 1, limit);
    }
}
