package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.GetAllOrder;
import br.com.iteris.itc.minishop.core.usecase.impl.GetAllOrderUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAllOrderConfig {
    @Bean
    public GetAllOrderUseCaseImpl getAllOrderUseCase(
            GetAllOrder getAllOrder
    ) {
        return new GetAllOrderUseCaseImpl(getAllOrder);
    }
}
