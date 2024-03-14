package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.FindCustomerById;
import br.com.iteris.itc.minishop.core.dataprovider.FindOrderById;
import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.core.domain.Order;
import br.com.iteris.itc.minishop.dataprovider.repository.CustomerRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.OrderRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.CustomerEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.OrderEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.CustomerEntityMapper;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.OrderEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdImpl implements FindCustomerById {
    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(UUID.fromString(id));

        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
