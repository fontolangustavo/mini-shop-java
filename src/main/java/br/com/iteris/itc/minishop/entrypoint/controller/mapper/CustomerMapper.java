package br.com.iteris.itc.minishop.entrypoint.controller.mapper;

import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.entrypoint.controller.request.StoreCustomerRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.request.UpdateCustomerRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.response.CustomerDetailResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("customer-mapper")
public class CustomerMapper {
    public Customer toCustomerToStore(StoreCustomerRequest customerRequest) {
        return new Customer(
                customerRequest.getCpf(),
                customerRequest.getPhone()
        );
    }
    public Customer toCustomerToUpdate(UpdateCustomerRequest customerRequest) {
        return new Customer(
                customerRequest.getCpf(),
                customerRequest.getPhone()
        );
    }
    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getCpf(),
                customer.getPhone()
        );
    }
    public CustomerDetailResponse toCustomerToDetailResponse(Customer customer, double amountSpend) {
        return new CustomerDetailResponse(
                customer.getId(),
                customer.getCpf(),
                customer.getPhone(),
                amountSpend
        );
    }
}
