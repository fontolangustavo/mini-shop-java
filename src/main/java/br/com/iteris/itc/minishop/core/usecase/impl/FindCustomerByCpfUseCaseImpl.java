package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindCustomerByCpf;
import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.FindCustomerByCpfUseCase;

import java.util.Optional;

public class FindCustomerByCpfUseCaseImpl implements FindCustomerByCpfUseCase {
    private final FindCustomerByCpf findCustomerByCpf;

    public FindCustomerByCpfUseCaseImpl(FindCustomerByCpf findCustomerByCpf) {
        this.findCustomerByCpf = findCustomerByCpf;
    }

    @Override
    public Customer findByCpf(String cpf) {
        Optional<Customer> customer = findCustomerByCpf.findByCpf(cpf);
        if(customer.isEmpty()) {
            throw new NotFoundException("Customer not found");
        }

        return customer.get();
    }
}
