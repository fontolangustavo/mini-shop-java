package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierByCnpj;
import br.com.iteris.itc.minishop.core.usecase.impl.FindSupplierByCnpjUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSupplierByCnpjConfig {
    @Bean
    public FindSupplierByCnpjUseCaseImpl findSupplierByCnpjUseCase(
            FindSupplierByCnpj findSupplierByCnpj
    ) {
        return new FindSupplierByCnpjUseCaseImpl(findSupplierByCnpj);
    }

}
