package com.alterach.sale.application.ports.in;

import com.alterach.sale.application.core.domain.Sale;

public interface CreateSaleInputPort {

    void create(Sale sale);
}
