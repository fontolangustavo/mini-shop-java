package br.com.iteris.itc.minishop.dataprovider.repository.mapper;

import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.CustomerEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityMapper {
    public CustomerEntity toCustomerEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity(
            customer.getId(),
            customer.getCpf(),
            customer.getPhone()
        );

        if (customer.getUser() != null) {
            UserEntity userEntity = new UserEntity();

            BeanUtils.copyProperties(customer.getUser(), userEntity);

            customerEntity.setUserEntity(userEntity);
        }

        return customerEntity;
    }

    public Customer toCustomer(CustomerEntity customerEntity) {
        return new Customer(
            customerEntity.getId(),
            customerEntity.getCpf(),
            customerEntity.getPhone()
        );
    }
}
