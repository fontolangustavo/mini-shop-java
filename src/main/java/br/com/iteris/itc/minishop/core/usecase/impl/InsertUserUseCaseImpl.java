
package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindUserByEmail;
import br.com.iteris.itc.minishop.core.dataprovider.InsertUser;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.core.exceptions.ValidationException;
import br.com.iteris.itc.minishop.core.usecase.InsertUserUseCase;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class InsertUserUseCaseImpl implements InsertUserUseCase {
    private final FindUserByEmail findUserByEmail;
    private final InsertUser insertUser;
    private final PasswordEncoder passwordEncoder;

    public InsertUserUseCaseImpl(
            FindUserByEmail findUserByEmail,
            InsertUser insertUser,
            PasswordEncoder passwordEncoder
    ) {
        this.findUserByEmail = findUserByEmail;
        this.insertUser = insertUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User insert(User user, String type) {
        Optional<User> userExists = findUserByEmail.findByEmail(user.getEmail(), type);

        if (userExists.isPresent()) {
            throw new ValidationException("That email is already registered");
        }

        user.setEmail(type + "_" + user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return insertUser.insert(user, type);
    }
}
