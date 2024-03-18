package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Customer;

public interface FindCustomerByIdUseCase {
    Customer find(final String id);
}
