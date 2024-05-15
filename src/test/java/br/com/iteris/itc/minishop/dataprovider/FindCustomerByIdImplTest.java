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

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FindCustomerByIdImplTest {
    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerEntityMapper mockCustomerEntityMapper;

    @InjectMocks
    private FindCustomerByIdImpl findCustomerById;

    @Test
    @DisplayName("should return customer on success")
    public void testFindCustomerByIdOnSuccess() {
        UUID customerId = UUID.randomUUID();
        String customerIdString = customerId.toString();

        CustomerEntity mockCustomerEntity = new CustomerEntity(
                customerId,
                "any_cpf",
                "any_phone"
        );

        Customer mockCustomer = new Customer();
        BeanUtils.copyProperties(mockCustomer,mockCustomer);

        when(mockCustomerEntityMapper.toCustomer(any(CustomerEntity.class))).thenReturn(mockCustomer);
        when(customerRepository.findById(any(UUID.class))).thenReturn(Optional.of(mockCustomerEntity));

        Optional<Customer> response = findCustomerById.find(customerIdString);

        assertAll("should return customer on success",
                () -> assertTrue(response.isPresent()),
                () -> assertEquals(mockCustomer.getId(), response.get().getId()),
                () -> verify(mockCustomerEntityMapper, times(1)).toCustomer(mockCustomerEntity)
        );
    }

    @Test
    @DisplayName("should throw when id is illegal")
    public void testShouldThrowWhenIdIsIllegal() {
        UUID customerId = UUID.randomUUID();
        String customerIdString = customerId.toString();

        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        Optional<Customer> response = findCustomerById.find(customerIdString);

        assertTrue(response.isEmpty());
    }
    @Test
    @DisplayName("should throw when customer not found")
    public void testShouldThrowWhenCustomerNotFound() {
        UUID customerId = UUID.randomUUID();
        String customerIdString = customerId.toString();

        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        Optional<Customer> response = findCustomerById.find(customerIdString);

        assertTrue(response.isEmpty());
    }
}
