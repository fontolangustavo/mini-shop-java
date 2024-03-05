package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Customer;
import org.springframework.data.domain.Page;

public interface GetAllCustomerUseCase {
    Page<Customer> getAll(int page, int limit);
}
