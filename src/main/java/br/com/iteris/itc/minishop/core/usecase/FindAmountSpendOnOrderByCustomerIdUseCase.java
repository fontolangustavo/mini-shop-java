package br.com.iteris.itc.minishop.core.usecase;

public interface FindAmountSpendOnOrderByCustomerIdUseCase {
    double find(final String customerId);
}
