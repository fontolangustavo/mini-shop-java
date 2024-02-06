package br.com.iteris.itc.minishop.entrypoint.controller.mapper;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.entrypoint.controller.request.ProductRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.response.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toProduct(ProductRequest productRequest) {
        return new Product(
                productRequest.getName(),
                productRequest.getPrice()
        );
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.isDiscontinued()
        );
    }
}
