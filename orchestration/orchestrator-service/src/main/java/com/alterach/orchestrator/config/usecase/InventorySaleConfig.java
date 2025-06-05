package com.alterach.orchestrator.config.usecase;


import com.alterach.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.alterach.orchestrator.application.core.usecase.InventoryFailureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventorySaleConfig {
        @Bean
        public InventoryFailureUseCase inventoryFailureUseCase (SendSaleToTopicAdapter sendSaleToTopicAdapter){
            return new InventoryFailureUseCase(sendSaleToTopicAdapter);
        }

}
