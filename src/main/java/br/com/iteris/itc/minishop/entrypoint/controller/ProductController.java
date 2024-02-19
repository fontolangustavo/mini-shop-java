package br.com.iteris.itc.minishop.entrypoint.controller;

import br.com.iteris.itc.minishop.core.usecase.GetAllProductUseCase;
import br.com.iteris.itc.minishop.entrypoint.controller.mapper.ProductMapper;
import br.com.iteris.itc.minishop.entrypoint.controller.response.ProductResponse;
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
    private ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll(
            @Valid @RequestParam(defaultValue = "1") @Min(1) int page,
            @Valid @RequestParam(defaultValue = "10") @Max(100) int limit ){
        var products = getAllProductUseCase.getAll(page, limit);

        var response = products.map((product) -> productMapper.toProductResponse(product));

        return ResponseEntity.ok().body(response);
    }
}
