package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.FindProductById;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.dataprovider.repository.ProductRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindProductByIdImpl implements FindProductById {
    private final ProductRepository productRepository;

    private final ProductEntityMapper productEntityMapper;

    @Override
    public Product find(String id) {
        var productEntity = productRepository.findById(UUID.fromString(id));

        if (productEntity.isEmpty()) {
            throw new NotFoundException("Product not found");
        }

        return productEntityMapper.toProduct(productEntity.get());
    }
}
