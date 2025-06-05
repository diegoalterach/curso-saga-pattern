package com.alterach.payment.application.ports.out;

import com.alterach.payment.application.core.domain.User;

public interface UpdateUserOutputPort {
    void update(User user);
}
