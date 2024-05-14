package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.FindUserByEmail;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.core.exceptions.ValidationException;
import br.com.iteris.itc.minishop.core.types.UserEnum;
import br.com.iteris.itc.minishop.core.usecase.LoginUserUseCase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import java.time.Instant;
import java.util.Optional;

public class LoginUserUseCaseImpl implements LoginUserUseCase {
    private final FindUserByEmail findUserByEmail;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;
    @Value("${jwt.expires-in}")
    private long expiresIn;
    @Value("${application.name}")
    private String applicationName;

    public LoginUserUseCaseImpl(FindUserByEmail findUserByEmail, PasswordEncoder passwordEncoder, JwtEncoder jwtEncoder) {
        this.findUserByEmail = findUserByEmail;
        this.passwordEncoder = passwordEncoder;
        this.jwtEncoder = jwtEncoder;
    }

    @Override
    public String login(String email, String password) {
        Optional<User> user = findUserByEmail.findByEmail(email, UserEnum.CUSTOMER.getType());

        if (user.isEmpty()) {
            throw new ValidationException("Invalid email or password. Please check your credentials and try again.");
        }

        if (!user.get().validatePassword(password, passwordEncoder)){
            throw new ValidationException("Invalid email or password. Please check your credentials and try again.");
        }

        Instant now = Instant.now();

        JwtClaimsSet claim = JwtClaimsSet.builder()
                .issuer(applicationName)
                .subject(user.get().getId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claim)).getTokenValue();
    }
}
