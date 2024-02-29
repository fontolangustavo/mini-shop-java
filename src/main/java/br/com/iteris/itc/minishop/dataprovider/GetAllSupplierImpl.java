package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.GetAllSupplier;
import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.dataprovider.repository.SupplierRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.SupplierEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.SupplierEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class GetAllSupplierImpl implements GetAllSupplier {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierEntityMapper supplierEntityMapper;


    @Override
    public Page<Supplier> getAll(int page, int limit) {
        Page<SupplierEntity> suppliersEntities = supplierRepository.findAll(PageRequest.of(page, limit));

        return suppliersEntities.map(supplierEntityMapper::toSupplier);
    }
}
