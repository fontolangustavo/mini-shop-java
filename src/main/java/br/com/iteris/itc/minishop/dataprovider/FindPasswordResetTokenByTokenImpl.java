package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.FindPasswordResetTokenByToken;
import br.com.iteris.itc.minishop.core.domain.PasswordResetToken;
import br.com.iteris.itc.minishop.dataprovider.repository.PasswordResetTokenRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.PasswordResetTokenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindPasswordResetTokenByTokenImpl implements FindPasswordResetTokenByToken {
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final PasswordResetTokenMapper passwordResetTokenMapper;
    @Override
    public Optional<PasswordResetToken> findByToken(String token) {
        var passwordResetTokenEntity = passwordResetTokenRepository.findOneByToken(token);

        return passwordResetTokenEntity.map(passwordResetTokenMapper::toPasswordResetToken);
    }
}
