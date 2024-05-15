package br.com.iteris.itc.minishop.entrypoint.controller.customer;

import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.core.domain.PasswordResetToken;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.core.usecase.*;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.mapper.CustomerMapper;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.mapper.SessionMapper;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.mapper.UserMapper;
import br.com.iteris.itc.minishop.core.types.UserEnum;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.request.ForgotPasswordRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.request.LoginUserRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.request.StoreUserRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.request.UpdateForgotPasswordRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.response.SessionUserResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.response.UserResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers/auth")
public class AuthController {
    private final InsertCustomerUseCase insertCustomerUseCase;
    private final InsertUserUseCase insertUserUseCase;
    private final LoginUserUseCase loginUserUseCase;
    private final FindUserByEmailUseCase findUserByEmailUserCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final InsertPasswordResetTokenUseCase insertPasswordResetTokenUseCase;
    private final FindPasswordResetTokenByTokenUseCase findPasswordResetTokenByTokenUseCase;
    private final UpdateUserPasswordUseCase updateUserPasswordUseCase;
    @Qualifier("customer.customer-mapper")
    private final CustomerMapper customerMapper;
    private final UserMapper userMapper;
    private final SessionMapper sessionMapper;

    public AuthController(
            InsertCustomerUseCase insertCustomerUseCase,
            InsertUserUseCase insertUserUseCase,
            LoginUserUseCase loginUserUseCase,
            FindUserByEmailUseCase findUserByEmailUserCase,
            FindUserByIdUseCase findUserByIdUseCase,
            InsertPasswordResetTokenUseCase insertPasswordResetTokenUseCase,
            FindPasswordResetTokenByTokenUseCase findPasswordResetTokenByTokenUseCase,
            UpdateUserPasswordUseCase updateUserPasswordUseCase,
            CustomerMapper customerMapper,
            UserMapper userMapper,
            SessionMapper sessionMapper
    ) {
        this.insertCustomerUseCase = insertCustomerUseCase;
        this.insertUserUseCase = insertUserUseCase;
        this.loginUserUseCase = loginUserUseCase;
        this.findUserByEmailUserCase = findUserByEmailUserCase;
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.insertPasswordResetTokenUseCase = insertPasswordResetTokenUseCase;
        this.findPasswordResetTokenByTokenUseCase = findPasswordResetTokenByTokenUseCase;
        this.updateUserPasswordUseCase = updateUserPasswordUseCase;
        this.customerMapper = customerMapper;
        this.userMapper = userMapper;
        this.sessionMapper = sessionMapper;
    }

    // @todo - Implementar endpoint para confirmação de cadastro
    // @todo - Implementar endpoint para registrar geolocalização
    // @todo - Implementar endpoint para login via Google
    // @todo - Implementar endpoint para login via Apple

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<UserResponse> register(@Valid @ModelAttribute StoreUserRequest request){
        User insertedUser = insertUserUseCase.insert(
                userMapper.toUserToStore(request), UserEnum.CUSTOMER.getType()
        );

        insertCustomerUseCase.insert(
            customerMapper.toCustomerToStore(request, insertedUser)
        );

        User user = findUserByIdUseCase.find(insertedUser.getId().toString());

        // @todo - Implementar envio de email com boas vindas
        // @todo - Adicionar dados para confirmação de cadastro no email de boas vindas

        var response = userMapper.toUserResponse(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<SessionUserResponse> login(@Valid @ModelAttribute LoginUserRequest request) {
        String token = loginUserUseCase.login(request.getEmail(), request.getPassword());

        User user = findUserByEmailUserCase.findByEmail(request.getEmail(), UserEnum.CUSTOMER.getType());

        // @todo - Implementar registro de device que efetuou o login na conta
        var response = sessionMapper.toSession(token, user);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/user")
    public ResponseEntity<UserResponse> user(JwtAuthenticationToken token) {
        User user = findUserByIdUseCase.find(token.getName());

        var response = userMapper.toUserResponse(user);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<Void> forgotPassword(@Valid @ModelAttribute ForgotPasswordRequest request) {
        User user = findUserByEmailUserCase.findByEmail(request.getEmail(), UserEnum.CUSTOMER.getType());

        insertPasswordResetTokenUseCase.insert(user);

        // @todo - Implementar envio de email

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/forgot-password/{token}")
    public ResponseEntity<Void> updateForgotPassword(
            @Valid @ModelAttribute UpdateForgotPasswordRequest request,
            @PathVariable String token
    ) {
        PasswordResetToken passwordResetToken = findPasswordResetTokenByTokenUseCase.findByToken(token);

        User user = findUserByIdUseCase.find(passwordResetToken.getUser().getId().toString());

        updateUserPasswordUseCase.update(user, request.getPassword());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
