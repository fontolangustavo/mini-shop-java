package br.com.iteris.itc.minishop.dataprovider.repository.mapper;

import br.com.iteris.itc.minishop.core.domain.PasswordResetToken;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.PasswordResetTokenEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class PasswordResetTokenMapper {
    public PasswordResetToken toPasswordResetToken(PasswordResetTokenEntity passwordResetTokenEntity) {
        PasswordResetToken passwordResetToken = new PasswordResetToken(
                passwordResetTokenEntity.getId(),
                passwordResetTokenEntity.getToken(),
                passwordResetTokenEntity.getExpiryAt(),
                passwordResetTokenEntity.getCreatedAt(),
                passwordResetTokenEntity.getUpdatedAt()
        );

        if (passwordResetTokenEntity.getUserEntity() != null) {
            User user = new User(
                    passwordResetTokenEntity.getUserEntity().getId(),
                    passwordResetTokenEntity.getUserEntity().getFirstName(),
                    passwordResetTokenEntity.getUserEntity().getLastName(),
                    passwordResetTokenEntity.getUserEntity().getType(),
                    passwordResetTokenEntity.getUserEntity().getEmail(),
                    passwordResetTokenEntity.getUserEntity().getPassword(),
                    passwordResetTokenEntity.getUserEntity().getBirthDate(),
                    passwordResetTokenEntity.getUserEntity().getCreatedAt(),
                    passwordResetTokenEntity.getUserEntity().getUpdatedAt()
            );

            passwordResetToken.setUser(user);
        }

        return passwordResetToken;
    }

    public PasswordResetTokenEntity toPasswordResetTokenEntity(PasswordResetToken passwordResetToken) {
        PasswordResetTokenEntity passwordResetTokenEntity = new PasswordResetTokenEntity();

        passwordResetTokenEntity.setId(passwordResetToken.getId());
        passwordResetTokenEntity.setToken(passwordResetToken.getToken());
        passwordResetTokenEntity.setExpiryAt(passwordResetToken.getExpiryAt());
        passwordResetTokenEntity.setCreatedAt(passwordResetToken.getCreatedAt());
        passwordResetTokenEntity.setUpdatedAt(passwordResetToken.getUpdatedAt());

        if (passwordResetToken.getUser() != null) {
            UserEntity userEntity = new UserEntity(
                    passwordResetToken.getUser().getId(),
                    passwordResetToken.getUser().getFirstName(),
                    passwordResetToken.getUser().getLastName(),
                    passwordResetToken.getUser().getType(),
                    passwordResetToken.getUser().getEmail(),
                    passwordResetToken.getUser().getPassword(),
                    passwordResetToken.getUser().getBirthDate(),
                    passwordResetToken.getUser().getCreatedAt(),
                    passwordResetToken.getUser().getUpdatedAt()
            );

            passwordResetTokenEntity.setUserEntity(userEntity);
        }

        return passwordResetTokenEntity;
    }
}
