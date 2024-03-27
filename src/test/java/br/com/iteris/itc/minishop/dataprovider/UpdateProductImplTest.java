package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.dataprovider.repository.ProductRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.ProductEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.ProductEntityMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UpdateProductImplTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductEntityMapper mockProductEntityMapper;

    @InjectMocks
    private UpdateProductImpl updateProduct;

    @Test
    @DisplayName("should update product with success")
    public void testInsertProductWithSuccess() {
        UUID productId = UUID.randomUUID();
        UUID supplierId = UUID.randomUUID();

        Supplier mockSupplier = new Supplier(
                supplierId,
                "any_name",
                "any_cnpj",
                "any_city",
                "any_uf",
                "any_phone",
                "any_email",
                "any_contact",
                null
        );

        Product mockProduct = new Product(productId, "any_name", new BigDecimal(123),  "any_image", false, mockSupplier);
        ProductEntity mockProductEntity = new ProductEntity();
        BeanUtils.copyProperties(mockProduct, mockProductEntity);

        when(productRepository.save(any(ProductEntity.class))).thenReturn(mockProductEntity);
        when(mockProductEntityMapper.toProductEntity(any(Product.class))).thenReturn(mockProductEntity);
        when(mockProductEntityMapper.toProduct(any(ProductEntity.class))).thenReturn(mockProduct);

        Product product = updateProduct.update(mockProduct);

        assertAll("should update product with success",
                () -> assertNotNull(product),
                () -> assertEquals(product.getName(), mockProduct.getName())
        );
    }
}
