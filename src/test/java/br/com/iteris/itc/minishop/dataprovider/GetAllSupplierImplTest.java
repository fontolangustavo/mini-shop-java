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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GetAllSupplierImplTest {
    @Mock
    private SupplierRepository supplierRepository;

    @Mock
    private SupplierEntityMapper supplierEntityMapper;

    @InjectMocks
    private GetAllSupplierImpl getAllSupplier;

    @Test
    @DisplayName("should return pagable with a list of suppliers")
    public void testGetAllSuppliersPaginated() {
        int page = 1;
        int pageSize = 10;
        UUID supplierId = UUID.randomUUID();
        String supplierIdString = supplierId.toString();

        List<SupplierEntity> supplierEntities = new ArrayList<>();
        supplierEntities.add(new SupplierEntity(
                supplierId,
                "any_name",
                "any_cnpj",
                "any_city",
                "any_uf",
                "any_phone",
                "any_email",
                "any_contact",
                null
        ));
        supplierEntities.add(new SupplierEntity(
                supplierId,
                "other_name",
                "other_cnpj",
                "other_city",
                "other_uf",
                "other_phone",
                "other_email",
                "other_contact",
                null
        ));
        Page<SupplierEntity> mockSupplierEntities = new PageImpl<>(supplierEntities);

        when(supplierRepository.findAll(PageRequest.of(page, pageSize))).thenReturn(mockSupplierEntities);

        Page<Supplier> result = getAllSupplier.getAll(page, pageSize);

        // Asserts
        assertEquals(2, result.getTotalElements());
    }

    @Test
    @DisplayName("should return pagable with a empty list of suppliers")
    public void testGetAllSuppliersWithEmptyList() {
        int page = 1;
        int pageSize = 10;

        Page<SupplierEntity> mockSupplierEntities = new PageImpl<>(new ArrayList<>());

        when(supplierRepository.findAll(PageRequest.of(page, pageSize))).thenReturn(mockSupplierEntities);


        Page<Supplier> result = getAllSupplier.getAll(page, pageSize);

        // Asserts
        assertEquals(0, result.getTotalElements());
    }
}
