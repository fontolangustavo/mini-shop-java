package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.User;

public interface FindUserByIdUseCase {
    User find(final String id);
}
