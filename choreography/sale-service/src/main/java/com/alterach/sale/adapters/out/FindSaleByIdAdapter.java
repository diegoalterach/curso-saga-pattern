package com.alterach.sale.adapters.out;

import com.alterach.sale.adapters.out.repository.SaleRepository;
import com.alterach.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.alterach.sale.application.core.domain.Sale;
import com.alterach.sale.application.ports.out.FindSaleByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindSaleByIdAdapter implements FindSaleByIdOutputPort {

    @Autowired
    private SaleRepository saleRepository;


    @Autowired
    private SaleEntityMapper saleEntityMapper;

    @Override
    public Optional<Sale> find(Integer saleId) {
        var saleEntity = saleRepository.findById(saleId);
        return saleEntity.map(saleEntityMapper::toSale);
    }
}
