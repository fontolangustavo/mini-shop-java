package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindPasswordResetTokenByToken;
import br.com.iteris.itc.minishop.core.dataprovider.InsertPasswordResetToken;
import br.com.iteris.itc.minishop.core.usecase.InsertPasswordResetTokenUseCase;
import br.com.iteris.itc.minishop.core.usecase.impl.FindPasswordResetTokenByTokenUseCaseImpl;
import br.com.iteris.itc.minishop.core.usecase.impl.InsertPasswordResetTokenUseCaseImpl;
import br.com.iteris.itc.minishop.dataprovider.FindPasswordResetTokenByTokenImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordResetTokenConfig {
    @Bean
    public InsertPasswordResetTokenUseCaseImpl insertPasswordResetTokenUseCase(
            InsertPasswordResetToken insertPasswordResetToken
    ) {
        return new InsertPasswordResetTokenUseCaseImpl(
                insertPasswordResetToken
        );
    }

    @Bean
    public FindPasswordResetTokenByTokenUseCaseImpl findPasswordResetTokenByTokenUseCase(
            FindPasswordResetTokenByToken findPasswordResetTokenByToken
    ) {
        return new FindPasswordResetTokenByTokenUseCaseImpl(
                findPasswordResetTokenByToken
        );
    }
}
