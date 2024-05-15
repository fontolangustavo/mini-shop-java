package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.dataprovider.UpdateUser;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.dataprovider.repository.UserRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.UserEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserImpl implements UpdateUser {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User update(User user) {
        UserEntity userEntity = userRepository.save(userEntityMapper.toUserEntity(user));

        return userEntityMapper.toUser(userEntity);
    }
}
