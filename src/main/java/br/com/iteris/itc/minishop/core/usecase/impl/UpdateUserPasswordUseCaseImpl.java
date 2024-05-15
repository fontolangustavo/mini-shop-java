package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.UpdateUser;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.core.types.UserEnum;
import br.com.iteris.itc.minishop.core.usecase.UpdateUserPasswordUseCase;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UpdateUserPasswordUseCaseImpl implements UpdateUserPasswordUseCase {
    private final UpdateUser updateUser;
    private final PasswordEncoder passwordEncoder;

    public UpdateUserPasswordUseCaseImpl(
            UpdateUser updateUser,
            PasswordEncoder passwordEncoder
    ) {
        this.updateUser = updateUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User update(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));

        return updateUser.update(user);
    }
}
