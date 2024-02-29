package br.com.iteris.itc.minishop.entrypoint.controller;

import br.com.iteris.itc.minishop.core.usecase.GetAllCustomerUseCase;
import br.com.iteris.itc.minishop.entrypoint.controller.mapper.CustomerMapper;
import br.com.iteris.itc.minishop.entrypoint.controller.request.GetAllRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.response.CustomerResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.ProductResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    @Autowired
    private GetAllCustomerUseCase getAllCustomerUseCase;
    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping
    public ResponseEntity<Page<CustomerResponse>> getAll(@Valid GetAllRequest request){
        var customers = getAllCustomerUseCase.getAll(request.getPage(), request.getLimit());

        var response = customers.map((customer) -> customerMapper.toCustomerResponse(customer));

        return ResponseEntity.ok().body(response);
    }
}
