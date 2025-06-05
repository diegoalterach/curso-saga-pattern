package com.alterach.inventory.adapters.in.consumer;

import com.alterach.inventory.adapters.out.message.SaleMessage;
import com.alterach.inventory.application.core.domain.enums.SaleEvent;
import com.alterach.inventory.application.ports.in.DebitInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiveSaleToDebitInventoryConsumer {


    @Autowired
    private DebitInventoryInputPort debitInventoryInputPort;

    @KafkaListener(topics = "tp-saga-inventory", groupId = "inventory-debit")
     public void receive(SaleMessage saleMessage){

        if(SaleEvent.PREPARE_INVENTORY.equals(saleMessage.getSaleEvent())){
            log.info("Start Separando mercadoria");

            debitInventoryInputPort.debit(saleMessage.getSale());

            log.info("End Separando mercadoria");

        }

    }

}
