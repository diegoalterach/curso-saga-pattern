package com.alterach.orchestrator.adapters.out;

import com.alterach.orchestrator.adapters.out.message.SaleMessage;
import com.alterach.orchestrator.application.core.domain.Sale;
import com.alterach.orchestrator.application.core.domain.enums.SaleEvent;
import com.alterach.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendSaleToTopicAdapter implements SendSaleToTopicOutputPort {


    @Autowired
    KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent saleEvent, String topic) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send(topic, saleMessage);
    }
}
