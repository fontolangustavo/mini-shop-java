package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.InsertPasswordResetToken;
import br.com.iteris.itc.minishop.core.dataprovider.InsertUser;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.dataprovider.repository.PasswordResetTokenRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.UserRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.PasswordResetTokenEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.UserEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
public class InsertPasswordResetTokenImpl implements InsertPasswordResetToken {
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public void insert(String token, User user, ZonedDateTime expiryAt) {
        UserEntity userEntity = userEntityMapper.toUserEntity(user);

         PasswordResetTokenEntity passwordResetTokenEntity = PasswordResetTokenEntity.builder()
                .token(token)
                .userEntity(userEntity)
                .expiryAt(expiryAt)
                .build();

        passwordResetTokenRepository.save(passwordResetTokenEntity);
    }
}
