package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindUserByEmail;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.usecase.FindUserByEmailUseCase;

import java.util.Optional;

public class FindUserByEmailUseCaseImpl implements FindUserByEmailUseCase {
    private final FindUserByEmail findUserByEmail;

    public FindUserByEmailUseCaseImpl(FindUserByEmail findUserByEmail) {
        this.findUserByEmail = findUserByEmail;
    }

    @Override
    public User findByEmail(String email, String type) {
        Optional<User> user = findUserByEmail.findByEmail(email, type);

        if(user.isEmpty()) {
            throw new NotFoundException("User not found");
        }

        return user.get();
    }
}
