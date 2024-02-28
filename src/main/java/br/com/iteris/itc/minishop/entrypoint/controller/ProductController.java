package br.com.iteris.itc.minishop.entrypoint.controller;

import br.com.iteris.itc.minishop.core.usecase.FindProductByIdUseCase;
import br.com.iteris.itc.minishop.core.usecase.GetAllProductUseCase;
import br.com.iteris.itc.minishop.core.usecase.InsertProductUseCase;
import br.com.iteris.itc.minishop.entrypoint.controller.mapper.ProductMapper;
import br.com.iteris.itc.minishop.entrypoint.controller.request.ProductRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.response.ProductResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.ProductWithSupplierResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private GetAllProductUseCase getAllProductUseCase;

    @Autowired
    private FindProductByIdUseCase findProductByIdUseCase;

    @Autowired
    private InsertProductUseCase insertProductUseCase;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<Page<ProductWithSupplierResponse>> getAll(
            @Valid @RequestParam(defaultValue = "1") @Min(1) int page,
            @Valid @RequestParam(defaultValue = "10") @Max(100) int limit ){
        var products = getAllProductUseCase.getAll(page, limit);

        var response = products.map((product) -> productMapper.toProductResponse(product));

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductWithSupplierResponse> show(@PathVariable String id) {
        var product = findProductByIdUseCase.find(id);

        var response = productMapper.toProductResponse(product);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<ProductWithSupplierResponse> store(@Valid @RequestBody ProductRequest productRequest) {
        var product = productMapper.toProduct(productRequest);

        var response = productMapper.toProductResponse(
                insertProductUseCase.insert(product, productRequest.getSupplierId())
        );

        return ResponseEntity.ok().body(response);
    }

}
