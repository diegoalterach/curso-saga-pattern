package com.alterach.sale.application.ports.out;

import com.alterach.sale.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> find(final Integer saleId);
}
