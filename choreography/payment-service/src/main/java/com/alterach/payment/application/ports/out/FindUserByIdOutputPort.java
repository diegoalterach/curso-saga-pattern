package com.alterach.payment.application.ports.out;

import com.alterach.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {

    Optional<User> find(final Integer userId);
}
