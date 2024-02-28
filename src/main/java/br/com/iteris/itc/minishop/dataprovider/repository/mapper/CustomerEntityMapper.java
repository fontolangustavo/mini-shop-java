package br.com.iteris.itc.minishop.dataprovider.repository.mapper;

import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityMapper {
    public CustomerEntity toCustomerEntity(Customer customer) {
        return new CustomerEntity(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getCpf(),
                customer.getEmail(),
                customer.getPhone()
        );
    }

    public Customer toCustomer(CustomerEntity customerEntity) {
        return new Customer(
                customerEntity.getId(),
                customerEntity.getFirstName(),
                customerEntity.getLastName(),
                customerEntity.getCpf(),
                customerEntity.getEmail(),
                customerEntity.getPhone()
        );
    }
}
