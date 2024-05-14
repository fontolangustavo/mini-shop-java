package br.com.iteris.itc.minishop.entrypoint.controller.customer.mapper;

import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.request.StoreUserRequest;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.response.CustomerResponse;
import br.com.iteris.itc.minishop.entrypoint.controller.customer.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class UserMapper {
    public User toUserToStore(StoreUserRequest userRequest) {
        return new User(
            userRequest.getFirstName(),
            userRequest.getLastName(),
            userRequest.getPassword(),
            userRequest.getEmail(),
            userRequest.getBirthDate()
        );
    }
    public UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse(
            user.getId(),
            user.getFullName(),
            user.getType(),
            user.getPassword(),
            user.getFormattedEmail(),
            user.getBirthDate(),
            null
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        userResponse.setCreatedAt(user.getCreatedAt().format(formatter));
        userResponse.setUpdatedAt(user.getUpdatedAt().format(formatter));

        if (user.getCustomer() != null) {
            CustomerResponse customerResponse = new CustomerResponse();

            BeanUtils.copyProperties(user.getCustomer(), customerResponse);

            userResponse.setCustomer(customerResponse);
        }

        return userResponse;
    }
}
