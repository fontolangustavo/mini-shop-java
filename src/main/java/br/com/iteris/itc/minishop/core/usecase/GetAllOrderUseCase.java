package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Order;
import org.springframework.data.domain.Page;

public interface GetAllOrderUseCase {
    Page<Order> getAll(int page, int limit);
}
