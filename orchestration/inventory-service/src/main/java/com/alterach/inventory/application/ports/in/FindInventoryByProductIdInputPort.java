package com.alterach.inventory.application.ports.in;

import com.alterach.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {
    Inventory find(Integer productId);
}
