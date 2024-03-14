package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Customer;

public interface InsertCustomerUseCase {
    Customer insert(Customer customer);
}
