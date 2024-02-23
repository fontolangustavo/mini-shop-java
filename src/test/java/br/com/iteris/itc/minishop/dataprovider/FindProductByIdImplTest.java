package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.dataprovider.repository.ProductRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.ProductEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.SupplierEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.ProductEntityMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FindProductByIdImplTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductEntityMapper mockProductEntityMapper;

    @InjectMocks
    private FindProductByIdImpl findProductById;

    @Test
    @DisplayName("should return product on success")
    public void testFindProductByIdOnSuccess() {
        UUID productId = UUID.randomUUID();
        String productIdString = productId.toString();

        ProductEntity mockProduct= new ProductEntity(productId, "Banana", new BigDecimal("4.99"), false,
                new SupplierEntity());

        when(mockProductEntityMapper.toProduct(any(ProductEntity.class))).thenReturn(new Product(productId, "Banana", new BigDecimal("4.99"), false,
                new Supplier()));
        when(productRepository.findById(any(UUID.class))).thenReturn(Optional.of(mockProduct));

        Optional<Product> response = findProductById.find(productIdString);

        assertAll("should return product on success",
                () -> assertTrue(response.isPresent()),
                () -> assertEquals(mockProduct.getName(), response.get().getName()),
                () -> verify(mockProductEntityMapper, times(1)).toProduct(mockProduct)
        );
    }

    @Test
    @DisplayName("should throw when id is illegal")
    public void testShouldThrowWhenIdIsIllegal() {
        UUID productId = UUID.randomUUID();
        String productIdString = productId.toString();

        when(productRepository.findById(productId)).thenReturn(Optional.empty());


        Optional<Product> response = findProductById.find(productIdString);

        //Asserts
        assertTrue(response.isEmpty());
    }
    @Test
    @DisplayName("should throw when product not found")
    public void testShouldThrowWhenProductNotFound() {
        UUID productId = UUID.randomUUID();
        String productIdString = productId.toString();

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        Optional<Product> response = findProductById.find(productIdString);

        //Asserts
        assertTrue(response.isEmpty());
    }
}
