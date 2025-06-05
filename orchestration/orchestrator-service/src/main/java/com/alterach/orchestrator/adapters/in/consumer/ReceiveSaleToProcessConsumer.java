package com.alterach.orchestrator.adapters.in.consumer;

import com.alterach.orchestrator.adapters.out.message.SaleMessage;
import com.alterach.orchestrator.application.ports.in.WorkflowInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ReceiveSaleToProcessConsumer {

    @Autowired
    private List<WorkflowInputPort> workflowInputPorts;

    @KafkaListener(topics = "tp-saga-orchestrator", groupId = "orchestrator")
    public void receive(SaleMessage saleMessage) {
        var workflow = workflowInputPorts.stream()
                .filter(w -> w.isCalledByTheEvent(saleMessage.getSaleEvent()))
                .findFirst()
                .orElse(null);

        if(workflow!=null){
            workflow.execute(saleMessage.getSale());
        }else {
            log.error("Event not found");
        }
    }

}
