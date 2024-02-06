package br.com.iteris.itc.minishop.dataprovider.client.mapper;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.dataprovider.client.response.ProductResponse;

public class ProductResponseMapper {
    public Product toProduct(ProductResponse productResponse) {
        return new Product(
                productResponse.getId(),
                productResponse.getName(),
                productResponse.getPrice(),
                productResponse.isDiscontinued()
        );
    }
}
