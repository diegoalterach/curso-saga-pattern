package com.alterach.payment.adapters.out;

import com.alterach.payment.adapters.out.repository.UserRepository;
import com.alterach.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.alterach.payment.application.core.domain.User;
import com.alterach.payment.application.ports.out.FindUserByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class FindUserByIdAdapter implements FindUserByIdOutputPort {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> find(Integer userId) {
        var useEntity = userRepository.findById(userId);
        return useEntity.map(userEntityMapper::toUser);
    }
}
