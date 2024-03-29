package br.com.iteris.itc.minishop.dataprovider.repository;

import br.com.iteris.itc.minishop.dataprovider.repository.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, UUID> {
    Optional<SupplierEntity> findOneByEmail(final String email);
    Optional<SupplierEntity> findOneByCnpj(final String email);
}
