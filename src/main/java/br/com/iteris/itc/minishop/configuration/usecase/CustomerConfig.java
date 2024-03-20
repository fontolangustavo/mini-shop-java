package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindCustomerByCpf;
import br.com.iteris.itc.minishop.core.dataprovider.FindCustomerById;
import br.com.iteris.itc.minishop.core.dataprovider.GetAllCustomer;
import br.com.iteris.itc.minishop.core.dataprovider.InsertCustomer;
import br.com.iteris.itc.minishop.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import br.com.iteris.itc.minishop.core.usecase.impl.GetAllCustomerUseCaseImpl;
import br.com.iteris.itc.minishop.core.usecase.impl.InsertCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    @Bean
    public GetAllCustomerUseCaseImpl getAllCustomerUseCase(
            GetAllCustomer getAllCustomer
    ) {
        return new GetAllCustomerUseCaseImpl(getAllCustomer);
    }
    @Bean
    public FindCustomerByIdUseCaseImpl findCustomerByIdUseCase(
            FindCustomerById findCustomerById
    ) {
        return new FindCustomerByIdUseCaseImpl(findCustomerById);
    }
    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(
            FindCustomerByCpf findCustomerByCpf,
            InsertCustomer insertCustomer
    ) {
        return new InsertCustomerUseCaseImpl(
                findCustomerByCpf,
                insertCustomer
        );
    }
}
