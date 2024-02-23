package br.com.iteris.itc.minishop.entrypoint.controller;

import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.usecase.FindSupplierByIdUseCase;
import br.com.iteris.itc.minishop.entrypoint.controller.mapper.SupplierMapper;
import br.com.iteris.itc.minishop.entrypoint.controller.response.SupplierResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.SupplierWithProductsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/suppliers")
public class SupplierController {
    @Autowired
    private FindSupplierByIdUseCase findSupplierByIdUseCase;

    @Autowired
    private SupplierMapper supplierMapper;

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> show (@PathVariable String id) {
        Supplier supplier = findSupplierByIdUseCase.find(id);

        SupplierWithProductsResponse response = supplierMapper.toSupplierResponse(supplier);

        return ResponseEntity.ok().body(response);
    }
}
