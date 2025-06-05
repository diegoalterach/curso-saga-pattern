package com.alterach.payment.config.usecase;

import com.alterach.payment.adapters.out.SavePaymentAdapter;
import com.alterach.payment.adapters.out.SendToKafkaAdapter;
import com.alterach.payment.adapters.out.UpdateUserAdapter;
import com.alterach.payment.application.core.usecase.FindUserByIdUseCase;
import com.alterach.payment.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(FindUserByIdUseCase findUserByIdUseCase,
                                                 UpdateUserAdapter updateUserAdapter,
                                                 SavePaymentAdapter savePaymentAdapter,
                                                 SendToKafkaAdapter sendToKafkaAdapter
    ) {
        return new SalePaymentUseCase(findUserByIdUseCase, updateUserAdapter, savePaymentAdapter, sendToKafkaAdapter);
    }
}
