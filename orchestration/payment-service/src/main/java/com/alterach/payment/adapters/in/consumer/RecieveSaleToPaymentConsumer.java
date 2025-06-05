package com.alterach.payment.adapters.in.consumer;

import com.alterach.payment.adapters.out.message.SaleMessage;
import com.alterach.payment.application.core.domain.enums.SaleEvent;
import com.alterach.payment.application.ports.in.SalePaymentInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RecieveSaleToPaymentConsumer {


    @Autowired
    private SalePaymentInputPort salePaymentInputPort;

    @KafkaListener(topics = "tp-saga-payment", groupId = "payment")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.EXECUTE_PAYMENT.equals(saleMessage.getSaleEvent())) {
            log.info("Start payment");
            salePaymentInputPort.payment(saleMessage.getSale());
            log.info("End payment");
        }
    }
}
