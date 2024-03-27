package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.dataprovider.repository.ProductRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.ProductEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.ProductEntityMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GetAllProductImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductEntityMapper productEntityMapper;

    @InjectMocks
    private GetAllProductImpl getAllProduct;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("should return pagable with a list of products")
    public void testGetAllProductsPaginated() {
        int page = 1;
        int pageSize = 10;

        List<ProductEntity> productEntities = new ArrayList<>();
        productEntities.add(new ProductEntity(UUID.randomUUID(), "Batata", new BigDecimal("10.0"), "any_image", false, null));
        productEntities.add(new ProductEntity(UUID.randomUUID(), "Banana", new BigDecimal("4.99"),"any_image",  false, null));

        Page<ProductEntity> mockProductEntities = new PageImpl<>(productEntities);


        when(productRepository.findAll(PageRequest.of(page, pageSize))).thenReturn(mockProductEntities);


        Page<Product> result = getAllProduct.getAll(page, pageSize);

        // Asserts
        assertEquals(2, result.getTotalElements());
    }


    @Test
    @DisplayName("should return pagable with a empty list of products")
    public void testGetAllProductsWithEmptyList() {
        int page = 1;
        int pageSize = 10;

        Page<ProductEntity> mockProductEntities = new PageImpl<>(new ArrayList<>());

        when(productRepository.findAll(PageRequest.of(page, pageSize))).thenReturn(mockProductEntities);


        Page<Product> result = getAllProduct.getAll(page, pageSize);

        // Asserts
        assertEquals(0, result.getTotalElements());
    }
}
