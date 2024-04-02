package br.com.iteris.itc.minishop.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindProductById;
import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierById;
import br.com.iteris.itc.minishop.core.dataprovider.UpdateProduct;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.impl.UpdateProductUseCaseImpl;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.ProductEntity;
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
public class UpdateCustomerUseCaseImplTest {
    @Mock
    private FindProductById findProductById;
    @Mock
    private FindSupplierById findSupplierById;
    @Mock
    private UpdateProduct updateProduct;

    @InjectMocks
    private UpdateProductUseCaseImpl updateProductUseCase;

    @Test
    @DisplayName("should update product with success")
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

        Product mockProduct = new Product(productId, "any_name", new BigDecimal(123), "any_image",  false, mockSupplier);
        ProductEntity mockProductEntity = new ProductEntity();
        BeanUtils.copyProperties(mockProduct, mockProductEntity);

        when(findProductById.find(any(String.class))).thenReturn(Optional.of(mockProduct));
        when(findSupplierById.find(any(String.class))).thenReturn(Optional.of(mockSupplier));
        when(updateProduct.update(any(Product.class))).thenReturn(mockProduct);

        Product product = updateProductUseCase.update(mockProduct, supplierIdString);

        assertAll("should update product with success",
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

        Product mockProduct = new Product(productId, "any_name", new BigDecimal(123), "any_image", false, mockSupplier);
        ProductEntity mockProductEntity = new ProductEntity();
        BeanUtils.copyProperties(mockProduct, mockProductEntity);

        when(findProductById.find(any(String.class))).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> updateProductUseCase.update(mockProduct, supplierIdString));
    }

    @Test
    @DisplayName("should throw when product not found")
    public void testThrowWhenProductNotFound() {
        UUID productId = UUID.randomUUID();
        UUID supplierId = UUID.randomUUID();
        String supplierIdString = supplierId.toString();

        Product mockProduct = new Product(productId, "any_name", new BigDecimal(123),"any_image",  false, null);
        ProductEntity mockProductEntity = new ProductEntity();
        BeanUtils.copyProperties(mockProduct, mockProductEntity);

        when(findProductById.find(any(String.class))).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> updateProductUseCase.update(mockProduct, supplierIdString));
    }
}
