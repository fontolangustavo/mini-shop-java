package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.InsertUser;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.dataprovider.repository.UserRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.UserEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertUserImpl implements InsertUser {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User insert(User user, String type) {
        UserEntity userEntity = userEntityMapper.toUserEntity(user);

        userEntity.setType(type);

        userRepository.saveAndFlush(userEntity);

        return userEntityMapper.toUser(userEntity);
    }
}
