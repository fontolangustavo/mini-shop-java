package br.com.iteris.itc.minishop.entrypoint.controller.mapper;

import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.entrypoint.controller.request.StoreCustomerRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.request.UpdateCustomerRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.response.CustomerDetailResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toCustomerToStore(StoreCustomerRequest customerRequest) {
        return new Customer(
                customerRequest.getFirstName(),
                customerRequest.getLastName(),
                customerRequest.getCpf(),
                customerRequest.getPhone(),
                customerRequest.getEmail()
        );
    }
    public Customer toCustomerToUpdate(UpdateCustomerRequest customerRequest) {
        return new Customer(
                customerRequest.getFirstName(),
                customerRequest.getLastName(),
                customerRequest.getCpf(),
                customerRequest.getPhone(),
                customerRequest.getEmail()
        );
    }
    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFullName(),
                customer.getPhone(),
                customer.getEmail()
        );
    }
    public CustomerDetailResponse toCustomerToDetailResponse(Customer customer, double amountSpend) {
        return new CustomerDetailResponse(
                customer.getId(),
                customer.getFullName(),
                customer.getPhone(),
                customer.getEmail(),
                amountSpend
        );
    }
}
