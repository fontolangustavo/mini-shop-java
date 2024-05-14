package br.com.iteris.itc.minishop.dataprovider.repository;

import br.com.iteris.itc.minishop.dataprovider.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findOneByEmail(final String email);
}
