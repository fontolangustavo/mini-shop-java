package br.com.iteris.itc.minishop.entrypoint.controller.customer.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionUserResponse {
    private String token;
    private UserResponse user;
}
