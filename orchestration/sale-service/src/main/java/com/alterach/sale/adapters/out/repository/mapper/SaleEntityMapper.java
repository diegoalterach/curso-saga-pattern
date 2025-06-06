package com.alterach.sale.adapters.out.repository.mapper;

import com.alterach.sale.adapters.out.repository.entity.SaleEntity;
import com.alterach.sale.application.core.domain.Sale;
import com.alterach.sale.application.core.domain.enums.SaleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SaleEntityMapper {

    @Mapping(source = "status", target = "statusId", qualifiedByName = "setStatusId")
    SaleEntity toSaleEntity(Sale sale);

    @Mapping(source = "statusId", target = "status", qualifiedByName = "setStatus")
    Sale toSale(SaleEntity saleEntity);

    @Named("setStatusId")
    default Integer setStatusId(SaleStatus saleStatus){
        return saleStatus.getStatusId();
    }

    @Named("setStatus")
    default SaleStatus setStatus(Integer saleStatusId){
        return SaleStatus.toEnum(saleStatusId);
    }
}
