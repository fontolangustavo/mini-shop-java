package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.GetAllCustomer;
import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.core.usecase.GetAllCustomerUseCase;
import org.springframework.data.domain.Page;

public class GetAllCustomerUseCaseImpl implements GetAllCustomerUseCase {

    private final GetAllCustomer getAllCustomer;

    public GetAllCustomerUseCaseImpl(GetAllCustomer getAllCustomer) {
        this.getAllCustomer = getAllCustomer;
    }

    @Override
    public Page<Customer> getAll(int page, int limit) {
        return getAllCustomer.getAll(page - 1, limit);
    }
}
