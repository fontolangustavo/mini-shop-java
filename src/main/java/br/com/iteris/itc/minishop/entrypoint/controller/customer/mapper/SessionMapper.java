package br.com.iteris.itc.minishop.entrypoint.controller.customer.mapper;

import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.response.SessionUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionMapper {
    private final UserMapper userMapper;

    public SessionUserResponse toSession(String token, User user) {
        return SessionUserResponse.builder()
                .token(token)
                .user(userMapper.toUserResponse(user))
                .build();
    }
}
