package com.alterach.sale.application.ports.out;

import com.alterach.sale.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale save(Sale sale);

}
