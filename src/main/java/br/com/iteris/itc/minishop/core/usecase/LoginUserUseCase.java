package br.com.iteris.itc.minishop.core.usecase;

import br.com.iteris.itc.minishop.core.domain.User;

public interface LoginUserUseCase {
    String login(String email, String password);
}
