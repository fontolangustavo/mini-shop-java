package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.Customer;

public interface FindCustomerByCpfUseCase {
    Customer findByCpf(final String cpf);
}
