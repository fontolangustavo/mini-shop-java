package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.*;
import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.UpdateCustomerUseCase;

import java.util.Optional;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {
    private final UpdateCustomer updateCustomer;

    private final FindCustomerById findCustomerById;

    public UpdateCustomerUseCaseImpl(
            UpdateCustomer updateCustomer,
            FindCustomerById findCustomerById) {
        this.updateCustomer = updateCustomer;
        this.findCustomerById = findCustomerById;
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> customerExists = findCustomerById.find(customer.getId().toString());
        if (customerExists.isEmpty()) {
            throw new NotFoundException("Customer not found");
        }

        return updateCustomer.update(customer);
    }
}
