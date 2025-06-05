package com.alterach.orchestrator.application.ports.in;

import com.alterach.orchestrator.application.core.domain.Sale;
import com.alterach.orchestrator.application.core.domain.enums.SaleEvent;

public interface WorkflowInputPort {

    void execute(Sale sale);

    boolean isCalledByTheEvent(SaleEvent saleEvent);
}
