package com.alterach.sale.application.ports.in;

import com.alterach.sale.application.core.domain.Sale;

public interface CancelSaleInputPort {

    void cancel(Sale sale);
}
