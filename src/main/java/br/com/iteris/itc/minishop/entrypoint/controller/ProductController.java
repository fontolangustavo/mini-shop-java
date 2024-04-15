package br.com.iteris.itc.minishop.entrypoint.controller;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.exceptions.ValidationException;
import br.com.iteris.itc.minishop.core.usecase.*;
import br.com.iteris.itc.minishop.entrypoint.controller.mapper.ProductMapper;
import br.com.iteris.itc.minishop.entrypoint.controller.request.StoreProductRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.request.UpdateProductRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.response.ProductWithSupplierResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    private UpdateProductUseCase updateProductUseCase;
    @Autowired
    private UploadFileToS3UseCase uploadFileToS3UseCase;
    @Autowired
    private DeleteFileFromS3UseCase deleteFileFromS3UseCase;

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
    public ResponseEntity<ProductWithSupplierResponse> store(@Valid @ModelAttribute StoreProductRequest storeProductRequest) throws IOException {
        var product = productMapper.toProduct(storeProductRequest);

        if (!storeProductRequest.getImage().isEmpty()) {
            String uploadedFile = uploadFileToS3UseCase.uploadFile(storeProductRequest.getImage());
            product.setImage(uploadedFile);
        }

        var response = productMapper.toProductResponse(
                insertProductUseCase.insert(product, storeProductRequest.getSupplierId())
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductWithSupplierResponse> update(
            @PathVariable String id,
            @Valid @ModelAttribute UpdateProductRequest productRequest
    ) throws IOException {
        Product product = findProductByIdUseCase.find(id);

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDiscontinued(productRequest.getIsDiscontinued());

        if (productRequest.getDeleteImage() != null) {
            if (product.getImage() != null && !product.getImage().equals(productRequest.getDeleteImage())) {
                throw new ValidationException("Image not found");
            }

            deleteFileFromS3UseCase.deleteFile(productRequest.getDeleteImage());

            product.setImage(null);
        }

        if (productRequest.getImage() != null) {
            if (product.getImage() != null) {
                deleteFileFromS3UseCase.deleteFile(productRequest.getDeleteImage());
            }

            String uploadedFile = uploadFileToS3UseCase.uploadFile(productRequest.getImage());
            product.setImage(uploadedFile);
        }

        updateProductUseCase.update(
                product,
                productRequest.getSupplierId()
        );

        ProductWithSupplierResponse response = productMapper.toProductResponse(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
