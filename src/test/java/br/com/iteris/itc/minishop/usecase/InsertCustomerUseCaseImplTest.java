package br.com.iteris.itc.minishop.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindCustomerByCpf;
import br.com.iteris.itc.minishop.core.dataprovider.InsertCustomer;
import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.exceptions.ValidationException;
import br.com.iteris.itc.minishop.core.usecase.impl.InsertCustomerUseCaseImpl;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.CustomerEntity;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InsertCustomerUseCaseImplTest {
    @Mock
    private InsertCustomer insertCustomer;
    @Mock
    private FindCustomerByCpf findCustomerByCpf;
    @InjectMocks
    private InsertCustomerUseCaseImpl insertCustomerUseCase;

    @Test
    @DisplayName("should insert customer with success")
    public void testInsertCustomerWithSuccess() {
        UUID customerId = UUID.randomUUID();
        String customerIdString = customerId.toString();

        Customer mockCustomer = new Customer(
                customerId,
                "any_cpf",
                "any_phone"
        );
        CustomerEntity mockCustomerEntity = new CustomerEntity();
        BeanUtils.copyProperties(mockCustomer, mockCustomerEntity);

        when(findCustomerByCpf.findByCpf(any(String.class))).thenReturn(Optional.empty());
        when(insertCustomer.insert(any(Customer.class))).thenReturn(mockCustomer);

        Customer customer = insertCustomerUseCase.insert(mockCustomer);

        assertAll("should insert customer with success",
                () -> assertNotNull(customer),
                () -> assertEquals(customer.getPhone(), mockCustomer.getPhone()),
                () -> assertEquals(customer.getCpf(), mockCustomer.getCpf())
        );
    }

    @Test
    @DisplayName("should throw when a customer with the same cpf already exists")
    public void testThrowWhenCnpjAlreadyExists() {
        UUID customerId = UUID.randomUUID();
        String customerIdString = customerId.toString();

        Customer mockCustomer = new Customer(
                customerId,
                "any_cpf",
                "any_phone"
        );
        CustomerEntity mockCustomerEntity = new CustomerEntity();
        BeanUtils.copyProperties(mockCustomer, mockCustomerEntity);

        when(findCustomerByCpf.findByCpf(any(String.class))).thenReturn(Optional.of(mockCustomer));

        assertThrows(ValidationException.class, () -> insertCustomerUseCase.insert(mockCustomer));
    }
}
