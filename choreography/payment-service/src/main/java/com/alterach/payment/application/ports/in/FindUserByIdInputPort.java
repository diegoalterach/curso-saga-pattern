package com.alterach.payment.application.ports.in;

import com.alterach.payment.application.core.domain.User;

public interface FindUserByIdInputPort {
    User find(final Integer id);

}
