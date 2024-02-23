package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.dataprovider.repository.SupplierRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.SupplierEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.SupplierEntityMapper;
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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FindSupplierByIdImplTest {
    @Mock
    private SupplierRepository supplierRepository;

    @Mock
    private SupplierEntityMapper supplierEntityMapper;

    @InjectMocks
    private FindSupplierByIdImpl findSupplierById;

    @Test
    @DisplayName("should return supplier on success")
    public void testFindSupplierByIdOnSuccess() {
        UUID supplierId = UUID.randomUUID();
        String supplierIdString = supplierId.toString();

        SupplierEntity mockSupplier = new SupplierEntity(
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

        Supplier supplier = new Supplier();

        BeanUtils.copyProperties(mockSupplier, supplier);

        when(supplierEntityMapper.toSupplier(any(SupplierEntity.class))).thenReturn(supplier);
        when(supplierRepository.findById(any(UUID.class))).thenReturn(Optional.of(mockSupplier));

        Optional<Supplier> response = findSupplierById.find(supplierIdString);

        assertAll("should return supplier on success",
                () -> assertNotNull(response),
                () -> assertEquals(mockSupplier.getName(), response.get().getName()),
                () -> verify(supplierEntityMapper, times(1)).toSupplier(mockSupplier)
        );
    }

    @Test
    @DisplayName("should throw when id is illegal")
    public void testShouldThrowWhenIdIsIllegal() {
        UUID supplierId = UUID.randomUUID();
        String supplierIdString = supplierId.toString();

        when(supplierRepository.findById(supplierId)).thenReturn(Optional.empty());


        Optional<Supplier> response = findSupplierById.find(supplierIdString);

        //Asserts
        assertTrue(response.isEmpty());
    }
    @Test
    @DisplayName("should throw when supplier not found")
    public void testShouldThrowWhenSupplierNotFound() {
        UUID supplierId = UUID.randomUUID();
        String supplierIdString = supplierId.toString();

        when(supplierRepository.findById(supplierId)).thenReturn(Optional.empty());

        Optional<Supplier> response = findSupplierById.find(supplierIdString);

        //Asserts
        assertTrue(response.isEmpty());
    }
}
