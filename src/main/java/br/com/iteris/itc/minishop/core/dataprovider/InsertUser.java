package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.User;

public interface InsertUser {
    User insert(User user, String type);
}
