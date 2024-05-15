package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.dataprovider.repository.CustomerRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.CustomerEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.CustomerEntityMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GetAllCustomerImplTest {
    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerEntityMapper customerEntityMapper;

    @InjectMocks
    private GetAllCustomerImpl getAllCustomer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("should return pagable with a list of customers")
    public void testGetAllCustomersPaginated() {
        int page = 1;
        int pageSize = 10;

        List<CustomerEntity> customerEntities = new ArrayList<>();
        customerEntities.add(new CustomerEntity(UUID.randomUUID(), "1231232321", "joao@gmail.com"));
        customerEntities.add(new CustomerEntity(UUID.randomUUID(),  "54353453553", "arroz@gmail.com"));

        Page<CustomerEntity> mockCustomerEntities = new PageImpl<>(customerEntities);


        when(customerRepository.findAll(PageRequest.of(page, pageSize))).thenReturn(mockCustomerEntities);


        Page<Customer> result = getAllCustomer.getAll(page, pageSize);

        // Asserts
        assertEquals(2, result.getTotalElements());
    }


    @Test
    @DisplayName("should return pagable with a empty list of customers")
    public void testGetAllCustomersWithEmptyList() {
        int page = 1;
        int pageSize = 10;

        Page<CustomerEntity> mockCustomerEntities = new PageImpl<>(new ArrayList<>());

        when(customerRepository.findAll(PageRequest.of(page, pageSize))).thenReturn(mockCustomerEntities);


        Page<Customer> result = getAllCustomer.getAll(page, pageSize);

        // Asserts
        assertEquals(0, result.getTotalElements());
    }
}
