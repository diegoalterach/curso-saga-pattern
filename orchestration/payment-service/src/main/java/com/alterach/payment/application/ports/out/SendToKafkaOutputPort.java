package com.alterach.payment.application.ports.out;

import com.alterach.payment.application.core.domain.Sale;
import com.alterach.payment.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {
    void send(Sale sale, SaleEvent event);
}
