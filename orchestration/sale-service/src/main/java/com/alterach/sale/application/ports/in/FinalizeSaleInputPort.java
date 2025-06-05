package com.alterach.sale.application.ports.in;

import com.alterach.sale.application.core.domain.Sale;

public interface FinalizeSaleInputPort {
    void finalize(Sale sale);
}
