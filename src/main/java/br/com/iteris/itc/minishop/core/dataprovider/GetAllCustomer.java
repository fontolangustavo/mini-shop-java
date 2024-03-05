package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Customer;
import org.springframework.data.domain.Page;

public interface GetAllCustomer {
    Page<Customer> getAll(int page, int limit);
}
