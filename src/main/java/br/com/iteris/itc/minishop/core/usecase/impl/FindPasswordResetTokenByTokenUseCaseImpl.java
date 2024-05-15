package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindPasswordResetTokenByToken;
import br.com.iteris.itc.minishop.core.domain.PasswordResetToken;
import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.exceptions.ValidationException;
import br.com.iteris.itc.minishop.core.usecase.FindPasswordResetTokenByTokenUseCase;

import java.util.Optional;

public class FindPasswordResetTokenByTokenUseCaseImpl implements FindPasswordResetTokenByTokenUseCase {
    private final FindPasswordResetTokenByToken findPasswordResetTokenByToken;

    public FindPasswordResetTokenByTokenUseCaseImpl(FindPasswordResetTokenByToken findPasswordResetTokenByToken) {
        this.findPasswordResetTokenByToken = findPasswordResetTokenByToken;
    }

    @Override
    public PasswordResetToken findByToken(String token) {
        Optional<PasswordResetToken> passwordResetTokenOptional = findPasswordResetTokenByToken.findByToken(token);

        if(passwordResetTokenOptional.isEmpty()) {
            throw new NotFoundException("The password reset token not found");
        }

        if(passwordResetTokenOptional.get().isTokenExpired()){
            throw new ValidationException("The token has been expired!");
        }

        return passwordResetTokenOptional.get();
    }
}
