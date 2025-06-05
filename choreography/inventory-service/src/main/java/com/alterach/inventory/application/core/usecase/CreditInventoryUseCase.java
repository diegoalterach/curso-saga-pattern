package com.alterach.inventory.application.core.usecase;

import com.alterach.inventory.application.core.domain.Sale;
import com.alterach.inventory.application.core.domain.enums.SaleEvent;
import com.alterach.inventory.application.ports.in.CreditInventoryInputPort;
import com.alterach.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.alterach.inventory.application.ports.out.SendToKafkaOutputPort;
import com.alterach.inventory.application.ports.out.UpdateInventoryOutputPort;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;
    private final SendToKafkaOutputPort sendToKafkaOutputPort;


    public CreditInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort, UpdateInventoryOutputPort updateInventoryOutputPort, SendToKafkaOutputPort sendToKafkaOutputPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }

    @Override
    public void credit(Sale sale){
        var inventory =  findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
        sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
    }
}
