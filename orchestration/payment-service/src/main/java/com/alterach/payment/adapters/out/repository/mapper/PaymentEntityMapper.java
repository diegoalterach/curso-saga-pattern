package com.alterach.payment.adapters.out.repository.mapper;

import com.alterach.payment.adapters.out.repository.entity.PaymentEntity;
import com.alterach.payment.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {
    PaymentEntity toPaymentEntity(Payment payment);
}
