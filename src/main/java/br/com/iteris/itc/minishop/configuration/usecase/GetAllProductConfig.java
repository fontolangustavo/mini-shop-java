package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.usecase.impl.GetAllProductUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.com.iteris.itc.minishop.core.dataprovider.GetAllProduct;

@Configuration
public class GetAllProductConfig {
    @Bean
    public GetAllProductUseCaseImpl getAllProductUseCase(
            GetAllProduct getAllProduct
    ) {
        return new GetAllProductUseCaseImpl(getAllProduct);
    }
}
