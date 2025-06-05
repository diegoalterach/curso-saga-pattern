package com.alterach.orchestrator.adapters.out.message;

import com.alterach.orchestrator.application.core.domain.Sale;
import com.alterach.orchestrator.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleMessage {

    private Sale sale;
    private SaleEvent saleEvent;

}
