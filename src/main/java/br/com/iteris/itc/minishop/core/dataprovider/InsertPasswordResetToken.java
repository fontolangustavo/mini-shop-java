package br.com.iteris.itc.minishop.core.dataprovider;

import br.com.iteris.itc.minishop.core.domain.User;

import java.time.ZonedDateTime;

public interface InsertPasswordResetToken {
    void insert(
            final String token,
            final User user,
            final ZonedDateTime expiryAt
    );
}
