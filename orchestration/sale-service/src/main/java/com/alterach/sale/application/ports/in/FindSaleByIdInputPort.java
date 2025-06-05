package com.alterach.sale.application.ports.in;

import com.alterach.sale.application.core.domain.Sale;

public interface FindSaleByIdInputPort {
    Sale find(Integer saleId);
}
