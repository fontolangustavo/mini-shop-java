package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindAmountSpendOnOrderByCustomerId;
import br.com.iteris.itc.minishop.core.usecase.FindAmountSpendOnOrderByCustomerIdUseCase;

public class FindAmountSpendOnOrderByCustomerIdUseCaseImpl implements FindAmountSpendOnOrderByCustomerIdUseCase {
    private final FindAmountSpendOnOrderByCustomerId findAmountSpendOnOrderByCustomerId;

    public FindAmountSpendOnOrderByCustomerIdUseCaseImpl(
            FindAmountSpendOnOrderByCustomerId findAmountSpendOnOrderByCustomerId
    ) {
        this.findAmountSpendOnOrderByCustomerId = findAmountSpendOnOrderByCustomerId;
    }

    @Override
    public double find(String customerId) {
        return findAmountSpendOnOrderByCustomerId.find(customerId);
    }
}
