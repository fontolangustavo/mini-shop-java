package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Product;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.dataprovider.repository.ProductRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.SupplierRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.ProductEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.SupplierEntity;
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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UpdateSupplierImplTest {
    @Mock
    private SupplierRepository supplierRepository;
    @Mock
    private SupplierEntityMapper mockSupplierEntityMapper;

    @InjectMocks
    private UpdateSupplierImpl updateSupplier;

    @Test
    @DisplayName("should update supplier with success")
    public void testInsertProductWithSuccess() {
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

        SupplierEntity mockSupplierEntity = new SupplierEntity();
        BeanUtils.copyProperties(mockSupplier, mockSupplierEntity);

        when(supplierRepository.save(any(SupplierEntity.class))).thenReturn(mockSupplierEntity);
        when(mockSupplierEntityMapper.toSupplierEntity(any(Supplier.class))).thenReturn(mockSupplierEntity);
        when(mockSupplierEntityMapper.toSupplier(any(SupplierEntity.class))).thenReturn(mockSupplier);

        Supplier supplier = updateSupplier.update(mockSupplier);

        assertAll("should update supplier with success",
                () -> assertNotNull(supplier),
                () -> assertEquals(mockSupplier.getName(), supplier.getName())
        );
    }
}
