package br.com.iteris.itc.minishop.entrypoint.controller;

import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.usecase.FindSupplierByIdUseCase;
import br.com.iteris.itc.minishop.core.usecase.GetAllSupplierUseCase;
import br.com.iteris.itc.minishop.entrypoint.controller.mapper.SupplierMapper;
import br.com.iteris.itc.minishop.entrypoint.controller.response.SupplierResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.SupplierWithProductsResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/suppliers")
public class SupplierController {
    @Autowired
    private GetAllSupplierUseCase getAllSupplierUseCase;

    @Autowired
    private FindSupplierByIdUseCase findSupplierByIdUseCase;

    @Autowired
    private SupplierMapper supplierMapper;

    @GetMapping
    public ResponseEntity<Page<SupplierResponse>> getAll(
            @Valid @RequestParam(defaultValue = "1") @Min(1) int page,
            @Valid @RequestParam(defaultValue = "10") @Max(100) int limit ){
        var suppliers = getAllSupplierUseCase.getAll(page, limit);

        var response = suppliers.map(supplierMapper::toSupplierResponse);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> show (@PathVariable String id) {
        Supplier supplier = findSupplierByIdUseCase.find(id);

        SupplierWithProductsResponse response = supplierMapper.toSupplierWithProductsResponse(supplier);

        return ResponseEntity.ok().body(response);
    }
}
