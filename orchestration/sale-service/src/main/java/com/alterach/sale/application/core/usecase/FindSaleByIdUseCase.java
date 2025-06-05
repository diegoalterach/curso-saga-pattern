package com.alterach.sale.application.core.usecase;

import com.alterach.sale.application.core.domain.Sale;
import com.alterach.sale.application.ports.in.FindSaleByIdInputPort;
import com.alterach.sale.application.ports.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase implements FindSaleByIdInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    public FindSaleByIdUseCase(FindSaleByIdOutputPort findSaleByIdOutputPort) {
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
    }
    @Override
    public Sale find(Integer saleId){
        return findSaleByIdOutputPort.find(saleId)
                .orElseThrow(()->new RuntimeException("Sale not found"));
    }
}
