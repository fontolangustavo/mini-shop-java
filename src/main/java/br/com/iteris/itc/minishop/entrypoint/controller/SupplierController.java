package br.com.iteris.itc.minishop.entrypoint.controller;

import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.usecase.FindSupplierByIdUseCase;
import br.com.iteris.itc.minishop.core.usecase.GetAllSupplierUseCase;
import br.com.iteris.itc.minishop.core.usecase.InsertSupplierUseCase;
import br.com.iteris.itc.minishop.core.usecase.UpdateSupplierUseCase;
import br.com.iteris.itc.minishop.entrypoint.controller.mapper.SupplierMapper;
import br.com.iteris.itc.minishop.entrypoint.controller.request.GetAllRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.request.StoreSupplierRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.request.UpdateSupplierRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.response.SupplierResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.SupplierWithProductsResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/suppliers")
public class SupplierController {
    @Autowired
    private GetAllSupplierUseCase getAllSupplierUseCase;

    @Autowired
    private FindSupplierByIdUseCase findSupplierByIdUseCase;

    @Autowired
    private InsertSupplierUseCase insertSupplierUseCase;

    @Autowired
    private UpdateSupplierUseCase updateSupplierUseCase;

    @Autowired
    private SupplierMapper supplierMapper;

    @GetMapping
    public ResponseEntity<Page<SupplierResponse>> getAll(@Valid GetAllRequest request){
        var suppliers = getAllSupplierUseCase.getAll(request.getPage(), request.getLimit());
        var response = suppliers.map(supplierMapper::toSupplierResponse);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> show (@PathVariable String id) {
        Supplier supplier = findSupplierByIdUseCase.find(id);

        SupplierWithProductsResponse response = supplierMapper.toSupplierWithProductsResponse(supplier);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<SupplierResponse> store(@Valid StoreSupplierRequest request) {
        Supplier supplier = insertSupplierUseCase.insert(new Supplier(
                request.getName(),
                request.getCnpj(),
                request.getCity(),
                request.getUf(),
                request.getPhone(),
                request.getEmail(),
                request.getContact()
        ));

        SupplierResponse  response = supplierMapper.toSupplierResponse(supplier);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponse> update(@Valid @RequestBody UpdateSupplierRequest supplierRequest, @PathVariable String id) {
        var supplier = supplierMapper.toSupplierFromUpdate(supplierRequest);

        supplier.setId(UUID.fromString(id));

        var response = supplierMapper.toSupplierResponse(
                updateSupplierUseCase.update(supplier)
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
