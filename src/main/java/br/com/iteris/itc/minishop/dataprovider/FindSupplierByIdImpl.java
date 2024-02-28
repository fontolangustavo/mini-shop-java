package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.FindSupplierById;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.dataprovider.repository.SupplierRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.SupplierEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.SupplierEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindSupplierByIdImpl implements FindSupplierById {

    private final SupplierRepository supplierRepository;
    private final SupplierEntityMapper supplierEntityMapper;

    @Override
    public Optional<Supplier> find(String id) {
        Optional<SupplierEntity> supplierEntity = supplierRepository.findById(UUID.fromString(id));

        return supplierEntity.map(supplierEntityMapper::toSupplier);
    }
}
