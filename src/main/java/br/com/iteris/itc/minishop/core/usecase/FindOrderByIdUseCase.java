package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Order;

public interface FindOrderByIdUseCase {
    Order find(final String id);
}
