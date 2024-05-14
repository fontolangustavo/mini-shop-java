package br.com.iteris.itc.minishop.dataprovider;

import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.dataprovider.repository.UserRepository;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.UserEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.mapper.UserEntityMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FindUserByEmailImplTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserEntityMapper userEntityMapper;

    @InjectMocks
    private FindUserByEmailImpl findUserByEmail;

    @Test
    @DisplayName("should return user on success")
    public void testFindUserByEmailOnSuccess() {
        UUID userId = UUID.randomUUID();

        UserEntity mockUser = new UserEntity(
                userId,
                "any_first_name",
                "any_last_name",
                "any_type",
                "any_password",
                "any_email@mail.com",
                new Date(),
                null,
                null
        );

        User user = new User();
        BeanUtils.copyProperties(mockUser, user);

        when(userEntityMapper.toUser(any(UserEntity.class))).thenReturn(user);
        when(userRepository.findOneByEmail(anyString())).thenReturn(Optional.of(mockUser));

        Optional<User> response = findUserByEmail.findByEmail("any_email", "any_type");

        assertAll("should return user on success",
                () -> assertNotNull(response),
                () -> assertEquals(mockUser.getEmail(), response.get().getEmail()),
                () -> verify(userEntityMapper, times(1)).toUser(mockUser)
        );
    }

    @Test
    @DisplayName("should throw when user not found")
    public void testShouldReturnEmptyWhenUserNotFound() {
        when(userRepository.findOneByEmail(anyString())).thenReturn(Optional.empty());

        Optional<User> response = findUserByEmail.findByEmail("wrong_email", "any_type");

        //Asserts
        assertTrue(response.isEmpty());
    }
}
