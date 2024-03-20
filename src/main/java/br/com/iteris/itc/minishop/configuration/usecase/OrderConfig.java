package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindAmountSpendOnOrderByCustomerId;
import br.com.iteris.itc.minishop.core.dataprovider.FindOrderById;
import br.com.iteris.itc.minishop.core.dataprovider.GetAllOrder;
import br.com.iteris.itc.minishop.core.usecase.impl.FindAmountSpendOnOrderByCustomerIdUseCaseImpl;
import br.com.iteris.itc.minishop.core.usecase.impl.FindOrderByIdUseCaseImpl;
import br.com.iteris.itc.minishop.core.usecase.impl.GetAllOrderUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {
    @Bean
    public GetAllOrderUseCaseImpl getAllOrderUseCase(
            GetAllOrder getAllOrder
    ) {
        return new GetAllOrderUseCaseImpl(getAllOrder);
    }
    @Bean
    public FindOrderByIdUseCaseImpl findOrderByIdUseCase(
            FindOrderById findOrderById
    ) {
        return new FindOrderByIdUseCaseImpl(findOrderById);
    }
    @Bean
    public FindAmountSpendOnOrderByCustomerIdUseCaseImpl findAmountSpendOnOrderByCustomerIdUseCase(
            FindAmountSpendOnOrderByCustomerId findAmountSpendOnOrderByCustomerId
    ) {
        return new FindAmountSpendOnOrderByCustomerIdUseCaseImpl(
                findAmountSpendOnOrderByCustomerId
        );
    }
}
