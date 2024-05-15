package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.User;

public interface UpdateUserPasswordUseCase {
    User update(User user, String password);
}
