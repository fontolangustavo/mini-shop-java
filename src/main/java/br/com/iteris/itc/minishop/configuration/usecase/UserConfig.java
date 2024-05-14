package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindUserByEmail;
import br.com.iteris.itc.minishop.core.dataprovider.FindUserById;
import br.com.iteris.itc.minishop.core.dataprovider.InsertUser;
import br.com.iteris.itc.minishop.core.dataprovider.UpdateUser;
import br.com.iteris.itc.minishop.core.usecase.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;

@Configuration
public class UserConfig {
    @Bean
    public InsertUserUseCaseImpl insertUserUseCase(
            FindUserByEmail findUserByEmail,
            InsertUser insertUser,
            PasswordEncoder passwordEncoder

    ) {
        return new InsertUserUseCaseImpl(findUserByEmail, insertUser, passwordEncoder);
    }

    @Bean
    public LoginUserUseCaseImpl loginUserUseCase(
            FindUserByEmail findUserByEmail,
            PasswordEncoder passwordEncoder,
            JwtEncoder jwtEncoder
    ) {
        return new LoginUserUseCaseImpl(findUserByEmail, passwordEncoder, jwtEncoder);
    }

    @Bean
    public FindUserByEmailUseCaseImpl findUserByEmailUseCase(
            FindUserByEmail findUserByEmail
    ) {
        return new FindUserByEmailUseCaseImpl(findUserByEmail);
    }

    @Bean
    public FindUserByIdUseCaseImpl findUserByIdUseCase(
            FindUserById findUserById
    ) {
        return new FindUserByIdUseCaseImpl(findUserById);
    }

    @Bean
    public UpdateUserPasswordUseCaseImpl updateUserPasswordUseCase(
            UpdateUser updateUser,
            PasswordEncoder passwordEncoder
    ) {
        return new UpdateUserPasswordUseCaseImpl(
                updateUser,
                passwordEncoder
        );
    }
}
