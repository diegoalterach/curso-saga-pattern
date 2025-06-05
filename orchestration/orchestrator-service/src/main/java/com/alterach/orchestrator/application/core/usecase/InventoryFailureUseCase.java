package com.alterach.orchestrator.application.core.usecase;

import com.alterach.orchestrator.application.core.domain.Sale;
import com.alterach.orchestrator.application.core.domain.enums.SaleEvent;
import com.alterach.orchestrator.application.ports.in.WorkflowInputPort;
import com.alterach.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryFailureUseCase implements WorkflowInputPort {
    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public InventoryFailureUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }


    @Override
    public void execute(Sale sale) {
        log.info("Cancelling Sale");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.CANCEL_SALE,"tp-saga-sale");
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.INVENTORY_ERROR.equals(saleEvent);
    }
}
