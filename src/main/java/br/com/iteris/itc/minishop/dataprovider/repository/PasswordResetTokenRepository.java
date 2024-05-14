package br.com.iteris.itc.minishop.dataprovider.repository;

import br.com.iteris.itc.minishop.dataprovider.repository.entity.PasswordResetTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetTokenEntity, UUID> {

    Optional<PasswordResetTokenEntity> findOneByToken(final String token);
}
