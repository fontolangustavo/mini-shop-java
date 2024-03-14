package br.com.iteris.itc.minishop.entrypoint.controller;

import br.com.iteris.itc.minishop.core.usecase.GetAllCustomerUseCase;
import br.com.iteris.itc.minishop.core.usecase.InsertCustomerUseCase;
import br.com.iteris.itc.minishop.entrypoint.controller.mapper.CustomerMapper;
import br.com.iteris.itc.minishop.entrypoint.controller.request.*;
import br.com.iteris.itc.minishop.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final GetAllCustomerUseCase getAllCustomerUseCase;
    private final InsertCustomerUseCase insertCustomerUseCase;
    private final CustomerMapper customerMapper;

    @GetMapping
    public ResponseEntity<Page<CustomerResponse>> getAll(@Valid GetAllRequest request){
        var customers = getAllCustomerUseCase.getAll(request.getPage(), request.getLimit());

        var response = customers.map(customerMapper::toCustomerResponse);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> store(@Valid @RequestBody StoreCustomerRequest customerRequest){
        var customer = insertCustomerUseCase.insert(customerMapper.toCustomerToStore(customerRequest));

        var response = customerMapper.toCustomerResponse(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
