package com.alterach.inventory.application.ports.in;

import com.alterach.inventory.application.core.domain.Sale;

public interface CreditInventoryInputPort {

    void credit(Sale sale);
}
