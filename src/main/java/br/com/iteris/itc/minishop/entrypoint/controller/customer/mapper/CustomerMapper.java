package br.com.iteris.itc.minishop.entrypoint.controller.customer.mapper;

import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.request.StoreUserRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.request.StoreCustomerRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.request.UpdateCustomerRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.response.CustomerDetailResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("customer.customer-mapper")
public class CustomerMapper {
    public Customer toCustomerToStore(StoreUserRequest userRequest, User user) {
        return new Customer(
            userRequest.getCpf(),
            userRequest.getPhone(),
            user
        );
    }
    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getCpf(),
                customer.getPhone()
        );
    }
}
