package com.alterach.sale.adapters.out;

import com.alterach.sale.adapters.out.message.SaleMessage;
import com.alterach.sale.application.core.domain.Sale;
import com.alterach.sale.application.core.domain.enums.SaleEvent;
import com.alterach.sale.application.ports.out.SendCreatedSaleOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCreatedSaleAdapter implements SendCreatedSaleOutputPort {
    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-saga-sale", saleMessage);

    }
}
