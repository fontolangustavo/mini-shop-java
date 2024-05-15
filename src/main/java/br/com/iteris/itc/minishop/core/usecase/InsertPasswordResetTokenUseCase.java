package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.User;

public interface InsertPasswordResetTokenUseCase {
    void insert(final User user);
}
