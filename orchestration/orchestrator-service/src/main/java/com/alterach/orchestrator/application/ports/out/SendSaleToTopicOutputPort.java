package com.alterach.orchestrator.application.ports.out;

import com.alterach.orchestrator.application.core.domain.Sale;
import com.alterach.orchestrator.application.core.domain.enums.SaleEvent;

public interface SendSaleToTopicOutputPort {

    void send(Sale sale, SaleEvent saleEvent, String topic);

}
