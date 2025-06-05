package com.alterach.inventory.application.core.usecase;

import com.alterach.inventory.application.core.domain.Inventory;
import com.alterach.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.alterach.inventory.application.ports.out.FindInventoryByProductIdOutputPort;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

    private final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

    public FindInventoryByProductIdUseCase(FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
    }


    @Override
    public Inventory find(Integer productId){
        return findInventoryByProductIdOutputPort.find(productId)
                .orElseThrow(()->new RuntimeException("Inventory not found"));
    }
}
