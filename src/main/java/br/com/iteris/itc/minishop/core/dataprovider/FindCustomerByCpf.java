package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByCpf {
    Optional<Customer> findByCpf(final String cpf);
}
