package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.User;

public interface InsertUserUseCase {
    User insert(User user, String type);
}
