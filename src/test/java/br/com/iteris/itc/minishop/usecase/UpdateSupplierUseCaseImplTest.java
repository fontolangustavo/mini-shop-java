package br.com.iteris.itc.minishop.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindProductById;
import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierById;
import br.com.iteris.itc.minishop.core.dataprovider.UpdateProduct;
import br.com.iteris.itc.minishop.core.dataprovider.UpdateSupplier;
import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.impl.UpdateProductUseCaseImpl;
import br.com.iteris.itc.minishop.core.usecase.impl.UpdateSupplierUseCaseImpl;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.ProductEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.SupplierEntity;
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
public class UpdateSupplierUseCaseImplTest {
    @Mock
    private FindSupplierById findSupplierById;
    @Mock
    private UpdateSupplier updateSupplier;

    @InjectMocks
    private UpdateSupplierUseCaseImpl updateSupplierUseCase;

    @Test
    @DisplayName("should update supplier with success")
    public void testInsertSupplierWithSuccess() {
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

        SupplierEntity mockSupplierEntity = new SupplierEntity();
        BeanUtils.copyProperties(mockSupplier, mockSupplierEntity);

        when(findSupplierById.find(any(String.class))).thenReturn(Optional.of(mockSupplier));
        when(updateSupplier.update(any(Supplier.class))).thenReturn(mockSupplier);

        Supplier supplier = updateSupplierUseCase.update(mockSupplier);

        assertAll("should update supplier with success",
                () -> assertNotNull(supplier),
                () -> assertEquals(supplier.getName(), mockSupplier.getName())
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

        SupplierEntity mockSupplierEntity = new SupplierEntity();
        BeanUtils.copyProperties(mockSupplier, mockSupplierEntity);

        when(findSupplierById.find(any(String.class))).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> updateSupplierUseCase.update(mockSupplier));
    }
}
