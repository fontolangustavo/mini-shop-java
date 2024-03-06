package br.com.iteris.itc.minishop.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.*;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.exceptions.ValidationException;
import br.com.iteris.itc.minishop.core.usecase.impl.InsertSupplierUseCaseImpl;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.SupplierEntity;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InsertSupplierUseCaseImplTest {
    @Mock
    private InsertSupplier insertSupplier;
    @Mock
    private FindSupplierByEmail findSupplierByEmail;
    @Mock
    private FindSupplierByCnpj findSupplierByCnpj;
    @InjectMocks
    private InsertSupplierUseCaseImpl insertSupplierUseCase;

    @Test
    @DisplayName("should insert supplier with success")
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

        when(findSupplierByEmail.findByEmail(any(String.class))).thenReturn(Optional.empty());
        when(findSupplierByCnpj.findByCnpj(any(String.class))).thenReturn(Optional.empty());
        when(insertSupplier.insert(any(Supplier.class))).thenReturn(mockSupplier);

        Supplier supplier = insertSupplierUseCase.insert(mockSupplier);

        assertAll("should insert supplier with success",
                () -> assertNotNull(supplier),
                () -> assertEquals(supplier.getName(), mockSupplier.getName())
        );
    }

    @Test
    @DisplayName("should throw when a supplier with the same email already exists")
    public void testThrowWhenEmailAlreadyExists() {
        UUID supplierId = UUID.randomUUID();
        String supplierIdString = supplierId.toString();

        Supplier mockSupplier = new Supplier(
                supplierId,
                "any_name",
                "any_cnpj",
                "any_city",
                "any_uf",
                "any_phone",
                "invalid_email",
                "any_contact",
                null
        );

        SupplierEntity mockSupplierEntity = new SupplierEntity();
        BeanUtils.copyProperties(mockSupplier, mockSupplierEntity);

        when(findSupplierByEmail.findByEmail(any(String.class))).thenReturn(Optional.of(mockSupplier));

        assertThrows(ValidationException.class, () -> insertSupplierUseCase.insert(mockSupplier));
    }

    @Test
    @DisplayName("should throw when a supplier with the same cnpj already exists")
    public void testThrowWhenCnpjAlreadyExists() {
        UUID supplierId = UUID.randomUUID();
        String supplierIdString = supplierId.toString();

        Supplier mockSupplier = new Supplier(
                supplierId,
                "any_name",
                "invalid_cnpj",
                "any_city",
                "any_uf",
                "any_phone",
                "any_email",
                "any_contact",
                null
        );

        SupplierEntity mockSupplierEntity = new SupplierEntity();
        BeanUtils.copyProperties(mockSupplier, mockSupplierEntity);

        when(findSupplierByEmail.findByEmail(any(String.class))).thenReturn(Optional.empty());
        when(findSupplierByCnpj.findByCnpj(any(String.class))).thenReturn(Optional.of(mockSupplier));

        assertThrows(ValidationException.class, () -> insertSupplierUseCase.insert(mockSupplier));
    }
}
