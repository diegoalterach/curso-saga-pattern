package com.alterach.sale.application.core.usecase;

import com.alterach.sale.application.core.domain.Sale;
import com.alterach.sale.application.core.domain.enums.SaleStatus;
import com.alterach.sale.application.ports.in.CancelSaleInputPort;
import com.alterach.sale.application.ports.in.FindSaleByIdInputPort;
import com.alterach.sale.application.ports.out.SaveSaleOutputPort;

public class CancelSaleUseCase implements CancelSaleInputPort {

    public final FindSaleByIdInputPort findSaleByIdInputPort;
    public final SaveSaleOutputPort saveSaleOutputPort;

    public CancelSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort, SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void cancel(Sale sale){
        var saleResponse = findSaleByIdInputPort.find(sale.getId());
        saleResponse.setStatus(SaleStatus.CANCELED);
        saveSaleOutputPort.save(saleResponse);
    }
}
