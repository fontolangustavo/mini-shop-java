package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.impl.InsertProductUseCaseImpl;
import br.com.iteris.itc.minishop.dataprovider.repository.ProductRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.ProductEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.ProductEntityMapper;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.SupplierEntityMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InsertProductImplTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductEntityMapper mockProductEntityMapper;

    @InjectMocks
    private InsertProductImpl insertProduct;

    @Test
    @DisplayName("should insert product with success")
    public void testInsertProductWithSuccess() {
        UUID productId = UUID.randomUUID();
        UUID supplierId = UUID.randomUUID();
        String supplierIdString = supplierId.toString();

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

        Product mockProduct = new Product(productId, "any_name", new BigDecimal(123),"any_image",  false, mockSupplier);
        ProductEntity mockProductEntity = new ProductEntity();
        BeanUtils.copyProperties(mockProduct, mockProductEntity);

        when(productRepository.save(any(ProductEntity.class))).thenReturn(mockProductEntity);
        when(mockProductEntityMapper.toProductEntity(any(Product.class))).thenReturn(mockProductEntity);
        when(mockProductEntityMapper.toProduct(any(ProductEntity.class))).thenReturn(mockProduct);

        Product product = insertProduct.insert(mockProduct);

        assertAll("should insert product with success",
                () -> assertNotNull(product),
                () -> assertEquals(product.getName(), mockProduct.getName())
        );
    }
}
