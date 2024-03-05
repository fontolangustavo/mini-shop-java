package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.GetAllCustomer;
import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.dataprovider.repository.CustomerRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class GetAllCustomerImpl implements GetAllCustomer {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Page<Customer> getAll(int page, int limit) {
        var customers = customerRepository.findAll(PageRequest.of(page,limit));

        return customers.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
