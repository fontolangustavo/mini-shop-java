package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.PasswordResetToken;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.PasswordResetTokenEntity;

import java.util.Optional;

public interface FindPasswordResetTokenByToken {
    Optional<PasswordResetToken> findByToken(final String token);
}
