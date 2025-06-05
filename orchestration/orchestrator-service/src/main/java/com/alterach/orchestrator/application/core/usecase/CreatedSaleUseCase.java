package com.alterach.orchestrator.application.core.usecase;

import com.alterach.orchestrator.application.core.domain.Sale;
import com.alterach.orchestrator.application.core.domain.enums.SaleEvent;
import com.alterach.orchestrator.application.ports.in.WorkflowInputPort;
import com.alterach.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreatedSaleUseCase implements WorkflowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public CreatedSaleUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }


    @Override
    public void execute(Sale sale) {
        log.info("Start inventory");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.PREPARE_INVENTORY,"tp-saga-inventory");
        //log.info("");
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.CREATED_SALE.equals(saleEvent);
    }

}
