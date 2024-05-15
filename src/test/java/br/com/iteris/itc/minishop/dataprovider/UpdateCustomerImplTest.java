package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.dataprovider.repository.CustomerRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.CustomerEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.CustomerEntityMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UpdateCustomerImplTest {
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerEntityMapper mockCustomerEntityMapper;

    @InjectMocks
    private UpdateCustomerImpl updateCustomer;

    @Test
    @DisplayName("should update customer with success")
    public void testInsertCustomerWithSuccess() {
        UUID customerId = UUID.randomUUID();

        Customer mockCustomer = new Customer(
                customerId,
                "any_cpf",
                "any_phone"
        );
        CustomerEntity mockCustomerEntity = new CustomerEntity();
        BeanUtils.copyProperties(mockCustomer, mockCustomerEntity);

        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(mockCustomerEntity);
        when(mockCustomerEntityMapper.toCustomerEntity(any(Customer.class))).thenReturn(mockCustomerEntity);
        when(mockCustomerEntityMapper.toCustomer(any(CustomerEntity.class))).thenReturn(mockCustomer);

        Customer customer = updateCustomer.update(mockCustomer);

        assertAll("should update customer with success",
                () -> assertNotNull(customer),
                () -> assertEquals(customer.getPhone(), mockCustomer.getPhone()),
                () -> assertEquals(customer.getCpf(), mockCustomer.getCpf())
        );
    }
}
