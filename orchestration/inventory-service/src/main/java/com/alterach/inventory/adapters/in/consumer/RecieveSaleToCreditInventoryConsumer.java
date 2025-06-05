package com.alterach.inventory.adapters.in.consumer;

import com.alterach.inventory.adapters.out.message.SaleMessage;
import com.alterach.inventory.application.core.domain.enums.SaleEvent;
import com.alterach.inventory.application.ports.in.CreditInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RecieveSaleToCreditInventoryConsumer {

    @Autowired
    private CreditInventoryInputPort creditInventoryInputPort;


    @KafkaListener(topics = "tp-saga-inventory",groupId = "inventory-credit")
    public void receive(SaleMessage saleMessage){
        if(SaleEvent.EXECUTE_ROLLBACK.equals(saleMessage.getSaleEvent())){
            log.info("Returning inventory");
            creditInventoryInputPort.credit(saleMessage.getSale());
            log.info("Inventory restored");
        }
    }

}
