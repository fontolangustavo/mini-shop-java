package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Order;

import java.util.List;

public interface FindAmountSpendOnOrderByCustomerId {
    double find(String customerId);
}
