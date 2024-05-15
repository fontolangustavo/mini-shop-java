package br.com.iteris.itc.minishop.dataprovider.repository.mapper;

import br.com.iteris.itc.minishop.core.domain.Customer;
import br.com.iteris.itc.minishop.core.domain.User;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.CustomerEntity;
import br.com.iteris.itc.minishop.dataprovider.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {
    public UserEntity toUserEntity(User user) {
        UserEntity userEntity = new UserEntity(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getType(),
            user.getEmail(),
            user.getPassword(),
            user.getBirthDate(),
            user.getCreatedAt(),
            user.getUpdatedAt()
        );

        if (user.getCustomer() != null) {
            userEntity.setCustomerEntity(new CustomerEntity(
                user.getCustomer().getId(),
                user.getCustomer().getCpf(),
                user.getCustomer().getPhone()
            ));
        }

        return userEntity;
    }

    public User toUser(UserEntity userEntity) {
        User user = new User(
            userEntity.getId(),
            userEntity.getFirstName(),
            userEntity.getLastName(),
            userEntity.getType(),
            userEntity.getPassword(),
            userEntity.getEmail(),
            userEntity.getBirthDate(),
            userEntity.getCreatedAt(),
            userEntity.getUpdatedAt()
        );

        if (userEntity.getCustomerEntity() != null) {
            user.setCustomer(new Customer(
                userEntity.getCustomerEntity().getId(),
                userEntity.getCustomerEntity().getCpf(),
                userEntity.getCustomerEntity().getPhone()
            ));
        }

        return user;
    }
}
