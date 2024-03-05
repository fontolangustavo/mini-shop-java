package br.com.iteris.itc.minishop.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierById;
import br.com.iteris.itc.minishop.core.dataprovider.InsertProduct;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.impl.InsertProductUseCaseImpl;
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
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InsertProductUseCaseImplTest {
    @Mock
    private FindSupplierById findSupplierById;
    @Mock
    private InsertProduct insertProduct;

    @InjectMocks
    private InsertProductUseCaseImpl insertProductUseCase;

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

        Product mockProduct = new Product(productId, "any_name", new BigDecimal(123), false, mockSupplier);
        ProductEntity mockProductEntity = new ProductEntity();
        BeanUtils.copyProperties(mockProduct, mockProductEntity);

        when(findSupplierById.find(any(String.class))).thenReturn(Optional.of(mockSupplier));
        when(insertProduct.insert(any(Product.class))).thenReturn(mockProduct);

        Product product = insertProductUseCase.insert(mockProduct, supplierIdString);

        assertAll("should insert product with success",
                () -> assertNotNull(product),
                () -> assertEquals(product.getName(), mockProduct.getName())
        );
    }

    @Test
    @DisplayName("should throw when supplier not found")
    public void testThrowWhenSupplierNotFound() {
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

        Product mockProduct = new Product(productId, "any_name", new BigDecimal(123), false, mockSupplier);
        ProductEntity mockProductEntity = new ProductEntity();
        BeanUtils.copyProperties(mockProduct, mockProductEntity);

        when(findSupplierById.find(any(String.class))).thenThrow(new NotFoundException());

        assertThrows(NotFoundException.class, () -> insertProductUseCase.insert(mockProduct, supplierIdString));
    }
}
