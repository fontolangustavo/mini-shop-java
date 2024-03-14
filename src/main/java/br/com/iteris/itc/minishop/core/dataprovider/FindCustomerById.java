package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.core.domain.Order;

import java.util.Optional;

public interface FindCustomerById {
    Optional<Customer> find(String id);
}
