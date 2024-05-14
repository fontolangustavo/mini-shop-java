package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.PasswordResetToken;

public interface FindPasswordResetTokenByTokenUseCase {
    public PasswordResetToken findByToken(final String token);
}
