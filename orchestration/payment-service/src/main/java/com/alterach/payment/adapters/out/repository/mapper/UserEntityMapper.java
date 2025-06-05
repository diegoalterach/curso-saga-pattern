package com.alterach.payment.adapters.out.repository.mapper;

import com.alterach.payment.adapters.out.repository.entity.UserEntity;
import com.alterach.payment.application.core.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);
}
