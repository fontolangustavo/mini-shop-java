package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.GetAllProduct;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.dataprovider.repository.ProductRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class GetAllProductImpl implements GetAllProduct {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductEntityMapper productEntityMapper;

    @Override
    public Page<Product> getAll(int page, int limit) {
        var products = productRepository.findAll(PageRequest.of(page, limit));

        return products.map(entity -> productEntityMapper.toProduct(entity));
    }
}
