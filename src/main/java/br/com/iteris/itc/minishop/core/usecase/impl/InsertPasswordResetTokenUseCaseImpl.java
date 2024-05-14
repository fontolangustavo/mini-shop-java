package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.InsertPasswordResetToken;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.core.usecase.InsertPasswordResetTokenUseCase;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.mapper.UserMapper;

import java.time.ZonedDateTime;
import java.util.UUID;

public class InsertPasswordResetTokenUseCaseImpl implements InsertPasswordResetTokenUseCase {
    private final InsertPasswordResetToken insertPasswordResetToken;

    public InsertPasswordResetTokenUseCaseImpl(InsertPasswordResetToken insertPasswordResetToken) {
        this.insertPasswordResetToken = insertPasswordResetToken;
    }

    @Override
    public void insert(User user) {
        String token = UUID.randomUUID().toString();

        long expiresIn = 5L;
        ZonedDateTime expiry_at = ZonedDateTime.now().plusMinutes(expiresIn);

        insertPasswordResetToken.insert(token, user, expiry_at);
    }
}
