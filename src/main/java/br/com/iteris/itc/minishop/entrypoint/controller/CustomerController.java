package br.com.iteris.itc.minishop.entrypoint.controller;

import br.com.iteris.itc.minishop.core.domain.Order;
import br.com.iteris.itc.minishop.core.usecase.FindCustomerByIdUseCase;
import br.com.iteris.itc.minishop.core.usecase.FindAmountSpendOnOrderByCustomerIdUseCase;
import br.com.iteris.itc.minishop.core.usecase.GetAllCustomerUseCase;
import br.com.iteris.itc.minishop.core.usecase.InsertCustomerUseCase;
import br.com.iteris.itc.minishop.core.usecase.UpdateCustomerUseCase;
import br.com.iteris.itc.minishop.entrypoint.controller.mapper.CustomerMapper;
import br.com.iteris.itc.minishop.entrypoint.controller.request.*;
import br.com.iteris.itc.minishop.entrypoint.controller.response.CustomerDetailResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.CustomerResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.SupplierResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final GetAllCustomerUseCase getAllCustomerUseCase;
    private final InsertCustomerUseCase insertCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final FindAmountSpendOnOrderByCustomerIdUseCase findAmountSpendOnOrderByCustomerIdUseCase;
    private final CustomerMapper customerMapper;

    @GetMapping
    public ResponseEntity<Page<CustomerResponse>> getAll(@Valid GetAllRequest request){
        var customers = getAllCustomerUseCase.getAll(request.getPage(), request.getLimit());

        var response = customers.map(customerMapper::toCustomerResponse);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetailResponse> show(@PathVariable String id) {
        var customer = findCustomerByIdUseCase.find(id);

        double amountSpend = findAmountSpendOnOrderByCustomerIdUseCase.find(customer.getId().toString());

        var response = customerMapper.toCustomerToDetailResponse(customer, amountSpend);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> store(@Valid @RequestBody StoreCustomerRequest customerRequest){
        var customer = insertCustomerUseCase.insert(customerMapper.toCustomerToStore(customerRequest));

        var response = customerMapper.toCustomerResponse(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(
            @Valid @RequestBody UpdateCustomerRequest customerRequest,
            @PathVariable String id
    ) {
        var customer = customerMapper.toCustomerToUpdate(customerRequest);

        customer.setId(UUID.fromString(id));

        var response = customerMapper.toCustomerResponse(
                updateCustomerUseCase.update(customer)
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
