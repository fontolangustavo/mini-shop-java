package br.com.iteris.itc.minishop.entrypoint.controller.mapper;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.entrypoint.controller.request.StoreProductRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.request.UpdateProductRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.response.ProductWithSupplierResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.response.SupplierResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProduct(StoreProductRequest storeProductRequest) {
        return new Product(
                storeProductRequest.getName(),
                storeProductRequest.getPrice()
        );
    }

    public Product toProductWithId(UpdateProductRequest productRequest) {
        return new Product(
                productRequest.getId(),
                productRequest.getName(),
                productRequest.getPrice(),
                productRequest.getIsDiscontinued()
        );
    }

    public ProductWithSupplierResponse toProductResponse(Product product) {
        return new ProductWithSupplierResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImage(),
                product.isDiscontinued(),
                new SupplierResponse(
                        product.getSupplier().getId(),
                        product.getSupplier().getName(),
                        product.getSupplier().getCnpj(),
                        product.getSupplier().getCity(),
                        product.getSupplier().getUf(),
                        product.getSupplier().getPhone(),
                        product.getSupplier().getEmail(),
                        product.getSupplier().getContact()
                )


        );
    }
}
