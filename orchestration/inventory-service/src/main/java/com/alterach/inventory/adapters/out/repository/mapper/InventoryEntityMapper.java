package com.alterach.inventory.adapters.out.repository.mapper;

import com.alterach.inventory.adapters.out.repository.entity.InventoryEntity;
import com.alterach.inventory.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {

    Inventory toInventory(InventoryEntity inventoryEntity);
    InventoryEntity toInventoryEntity(Inventory inventory);
}
