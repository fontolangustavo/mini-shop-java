package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindCustomerById;
import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.FindCustomerByIdUseCase;

import java.util.Optional;

public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {
    private final FindCustomerById findCustomerById;

    public FindCustomerByIdUseCaseImpl(FindCustomerById findCustomerById) {
        this.findCustomerById = findCustomerById;
    }

    @Override
    public Customer find(String id) {
        Optional<Customer> customer = findCustomerById.find(id);

        if (customer.isEmpty()) {
            throw new NotFoundException("Customer not found");
        }

        return customer.get();
    }
}
