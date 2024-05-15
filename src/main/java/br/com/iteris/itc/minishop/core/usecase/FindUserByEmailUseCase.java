package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.User;

public interface FindUserByEmailUseCase {
    User findByEmail(final String email, final String type);
}
