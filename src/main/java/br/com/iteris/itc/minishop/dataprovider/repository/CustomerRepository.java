package br.com.iteris.itc.minishop.dataprovider.repository;

import br.com.iteris.itc.minishop.dataprovider.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
    Optional<CustomerEntity> findOneByCpf(final String cpf);
}
