package br.com.iteris.itc.minishop.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.FindUserByEmail;
import br.com.iteris.itc.minishop.core.dataprovider.InsertUser;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.core.exceptions.ValidationException;
import br.com.iteris.itc.minishop.core.usecase.impl.InsertUserUseCaseImpl;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.UserEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.UserEntity;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InsertUserUseCaseImplTest {
    @Mock
    private FindUserByEmail findUserByEmail;
    @Mock
    private InsertUser insertUser;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private InsertUserUseCaseImpl insertUserUseCase;

    @Test
    @DisplayName("should insert user with success")
    public void testInsertUserWithSuccess(){
        UUID userId = UUID.randomUUID();

        User mockUser = new User(
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

        UserEntity mockUserEntity = new UserEntity();
        BeanUtils.copyProperties(mockUser, mockUserEntity);

        when(findUserByEmail.findByEmail(anyString(), anyString())).thenReturn(Optional.empty());
        when(insertUser.insert(any(User.class), anyString())).thenReturn(mockUser);

        User user = insertUserUseCase.insert(mockUser, "any_type");

        assertAll(
            () -> assertNotNull(user)
        );
    }

    @Test
    @DisplayName("should throw when a user with the same email already exists")
    public void testThrowWhenEmailAlreadyExists() {
        UUID userId = UUID.randomUUID();

        User mockUser = new User(
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
        UserEntity mockUserEntity = new UserEntity();
        BeanUtils.copyProperties(mockUser, mockUserEntity);

        when(findUserByEmail.findByEmail(any(String.class), anyString())).thenReturn(Optional.of(mockUser));

        assertThrows(ValidationException.class, () -> insertUserUseCase.insert(mockUser, "any_type"));
    }

    @Test
    @DisplayName("should call password crypt when insert user with success")
    public void testCallPasswordCryptWhenInsertUserWithSuccess(){
        UUID userId = UUID.randomUUID();

        User mockUser = new User(
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

        UserEntity mockUserEntity = new UserEntity();
        BeanUtils.copyProperties(mockUser, mockUserEntity);

        when(findUserByEmail.findByEmail(anyString(), anyString())).thenReturn(Optional.empty());
        when(insertUser.insert(any(User.class), anyString())).thenReturn(mockUser);
        when(passwordEncoder.encode(anyString())).thenReturn("crypt_password");

        User user = insertUserUseCase.insert(mockUser, "any_type");

        assertAll(
            () -> assertNotNull(user),
            () -> verify(passwordEncoder).encode("any_password"),
            () -> assertEquals(user.getPassword(), "crypt_password")
        );
    }
}
