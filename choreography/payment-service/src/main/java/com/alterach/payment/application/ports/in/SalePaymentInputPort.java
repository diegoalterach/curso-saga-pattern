package com.alterach.payment.application.ports.in;

import com.alterach.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {
    void payment(Sale sale);
}
