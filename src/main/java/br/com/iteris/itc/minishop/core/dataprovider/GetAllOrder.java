package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Order;
import org.springframework.data.domain.Page;

public interface GetAllOrder {
    Page<Order> getAll(int page, int limit);
}
