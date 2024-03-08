package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.InsertSupplier;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.dataprovider.repository.SupplierRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.SupplierEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.SupplierEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertSupplierImpl implements InsertSupplier {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierEntityMapper supplierEntityMapper;

    @Override
    public Supplier insert(Supplier supplier) {
        SupplierEntity supplierEntity = supplierRepository.save(supplierEntityMapper.toSupplierEntity(supplier));

        return supplierEntityMapper.toSupplier(supplierEntity);
    }
}
