package com.alterach.inventory.application.ports.out;

import com.alterach.inventory.application.core.domain.Sale;
import com.alterach.inventory.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);
}
