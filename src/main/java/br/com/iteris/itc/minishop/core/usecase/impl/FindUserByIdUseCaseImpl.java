package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindUserById;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.FindUserByIdUseCase;

import java.util.Optional;

public class FindUserByIdUseCaseImpl implements FindUserByIdUseCase {
    private final FindUserById findUserById;

    public FindUserByIdUseCaseImpl(FindUserById findUserById) {
        this.findUserById = findUserById;
    }

    @Override
    public User find(String id) {
        Optional<User> user = findUserById.find(id);

        if (user.isEmpty()) {
            throw new NotFoundException("Customer not found");
        }

        return user.get();
    }
}
