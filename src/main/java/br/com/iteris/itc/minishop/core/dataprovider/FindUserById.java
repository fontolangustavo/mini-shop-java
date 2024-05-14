package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.User;

import java.util.Optional;

public interface FindUserById {
    Optional<User> find(final String id);
}
