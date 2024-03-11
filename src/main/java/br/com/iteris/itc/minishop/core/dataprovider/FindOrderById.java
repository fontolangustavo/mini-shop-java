package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Order;

import java.util.Optional;

public interface FindOrderById {
    Optional<Order> find(String id);
}
