package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.Supplier;
import br.com.iteris.itc.minishop.core.domain.User;

import java.util.Optional;

public interface FindUserByEmail {
    Optional<User> findByEmail (final String email, final String type);
}
