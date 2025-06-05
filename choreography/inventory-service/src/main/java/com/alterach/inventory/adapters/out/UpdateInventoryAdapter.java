package com.alterach.inventory.adapters.out;

import com.alterach.inventory.adapters.out.repository.InventoryRepository;
import com.alterach.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.alterach.inventory.application.core.domain.Inventory;
import com.alterach.inventory.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private InventoryEntityMapper inventoryEntityMapper;

    @Override
    public void update(Inventory inventory) {
        inventoryRepository.save(inventoryEntityMapper.toInventoryEntity(inventory));
    }
}
