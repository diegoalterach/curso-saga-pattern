package com.alterach.payment.application.ports.out;

import com.alterach.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {
    void save(Payment payment);
}
