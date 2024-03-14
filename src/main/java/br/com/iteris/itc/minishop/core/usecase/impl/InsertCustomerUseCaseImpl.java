package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindCustomerByCpf;
import br.com.iteris.itc.minishop.core.dataprovider.InsertCustomer;
import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.core.exceptions.ValidationException;
import br.com.iteris.itc.minishop.core.usecase.InsertCustomerUseCase;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.CustomerEntityMapper;

import java.util.Optional;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {
    private final FindCustomerByCpf findCustomerByCpf;
    private final InsertCustomer insertCustomer;

    public InsertCustomerUseCaseImpl(
            FindCustomerByCpf findCustomerByCpf,
            InsertCustomer insertCustomer
    ) {
        this.findCustomerByCpf = findCustomerByCpf;
        this.insertCustomer = insertCustomer;
    }

    @Override
    public Customer insert(Customer customer) {
        Optional<Customer> customerExists = findCustomerByCpf.findByCpf(customer.getCpf());

        if (customerExists.isPresent()) {
            throw new ValidationException("That cpf is already registered");
        }

        return insertCustomer.insert(customer);
    }
}
