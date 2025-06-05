package com.alterach.inventory.application.ports.out;

import com.alterach.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update(Inventory inventory);

}
