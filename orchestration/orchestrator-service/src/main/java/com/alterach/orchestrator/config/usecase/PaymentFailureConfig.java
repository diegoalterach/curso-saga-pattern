package com.alterach.orchestrator.config.usecase;


import com.alterach.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.alterach.orchestrator.application.core.usecase.PaymentFailureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentFailureConfig {
        @Bean
        public PaymentFailureUseCase paymentFailureUseCase (SendSaleToTopicAdapter sendSaleToTopicAdapter){
            return new PaymentFailureUseCase(sendSaleToTopicAdapter);
        }

}
