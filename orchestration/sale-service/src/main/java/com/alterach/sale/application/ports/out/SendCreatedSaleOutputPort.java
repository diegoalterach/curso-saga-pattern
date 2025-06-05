package com.alterach.sale.application.ports.out;

import com.alterach.sale.application.core.domain.Sale;
import com.alterach.sale.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {
    void send(Sale sale, SaleEvent event);
}
