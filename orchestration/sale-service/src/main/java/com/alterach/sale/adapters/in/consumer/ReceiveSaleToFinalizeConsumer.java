package com.alterach.sale.adapters.in.consumer;

import com.alterach.sale.adapters.out.message.SaleMessage;
import com.alterach.sale.application.core.domain.enums.SaleEvent;
import com.alterach.sale.application.ports.in.FinalizeSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToFinalizeConsumer {

    @Autowired
    private FinalizeSaleInputPort finalizeSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-finalize")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.FINALIZE_SALE.equals(saleMessage.getSaleEvent())) {
            log.info("Finalizing Sale");
            finalizeSaleInputPort.finalize(saleMessage.getSale());
            log.info("Sale finalized");
        }

    }

}
