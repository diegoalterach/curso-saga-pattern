package com.alterach.sale.adapters.in.controller.mapper;

import com.alterach.sale.adapters.in.controller.request.SaleRequest;
import com.alterach.sale.application.core.domain.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    Sale toSale(SaleRequest saleRequest);
}
