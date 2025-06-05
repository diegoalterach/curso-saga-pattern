package com.alterach.orchestrator.config.usecase;


import com.alterach.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.alterach.orchestrator.application.core.usecase.PaymentExecutedUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentExecutedConfig {
        @Bean
        public PaymentExecutedUseCase paymentExecutedUseCase (SendSaleToTopicAdapter sendSaleToTopicAdapter){
            return new PaymentExecutedUseCase(sendSaleToTopicAdapter);
        }

}
